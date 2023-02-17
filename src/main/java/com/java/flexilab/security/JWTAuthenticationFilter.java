// Define el paquete donde se encuentra la clase
package com.java.flexilab.security;

// Importa las librerías necesarias de Spring Security, Jackson y Java
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

// Utiliza la anotación "@Component" de Spring para indicar que esta clase es un componente de la aplicación
@Component
// Define una clase llamada "JWTAuthenticationFilter" que extiende la clase "UsernamePasswordAuthenticationFilter" de Spring Security
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    // Define un campo final para el administrador de autenticación de Spring Security
    @Autowired
    AuthenticationManager authenticationManager;

    // Define un constructor que recibe el administrador de autenticación de Spring Security y establece la ruta de la solicitud para la autenticación de usuario
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
    }

    // Sobrescribe el método "attemptAuthentication()" para procesar la autenticación del usuario
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        // Crea un objeto "AuthCredentials" para almacenar las credenciales de autenticación del usuario
        AuthCredentials authCredentials = new AuthCredentials();
        try {
            // Utiliza la librería Jackson para leer las credenciales de autenticación del usuario desde la solicitud y almacenarlas en el objeto "AuthCredentials"
            authCredentials = new ObjectMapper().readValue(request.getInputStream(), AuthCredentials.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Crea un objeto "UsernamePasswordAuthenticationToken" con las credenciales de autenticación del usuario y una lista vacía de autoridades
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authCredentials.getEmail(),
                authCredentials.getPassword(),
                Collections.emptyList()
        );
        // Retorna el resultado de la autenticación a través del administrador de autenticación de Spring Security
        return authenticationManager.authenticate(authenticationToken);
    }

    // Sobrescribe el método "successfulAuthentication()" para generar y enviar una respuesta de autenticación exitosa al usuario
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        // Obtiene el principal de la autenticación exitosa.
        Object principal = authResult.getPrincipal();
        if (principal instanceof UserDetails) {
            // Si el principal es un UserDetails, obtiene las autoridades asociadas.
            UserDetails userDetails = (UserDetails) principal;
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            // Crea un token JWT usando el nombre de usuario y las autoridades.
            String token = TokenUtils.createToken(userDetails.getUsername(),
                    userDetails.getAuthorities().stream()
                            .map(GrantedAuthority::getAuthority)
                            .collect(Collectors.joining(","))
            );

            // Agrega el token al encabezado de autorización de la respuesta.
            response.addHeader("Authorization", "Bearer " + token);
            // Envía la respuesta al cliente.
            response.getWriter().flush();
        }

        // Continúa con la autenticación exitosa.
        super.successfulAuthentication(request, response, chain, authResult);
    }
}
