package com.java.flexilab.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // Obtiene el encabezado de autorización de la solicitud.
        String bearerToken = request.getHeader("Authorization");

        // Verifica si el token de portador es nulo o no comienza con "Bearer".
        if (bearerToken == null || !bearerToken.startsWith("Bearer ")) {
            // Si el token de portador es inválido, pasa la solicitud y la respuesta al siguiente filtro en la cadena.
            filterChain.doFilter(request, response);
            return;
        }

        // Si el token de portador es válido, extrae el token de la cadena.
        String token = bearerToken.replace("Bearer ", "");
        // Obtiene el token de autenticación a partir del token JWT.
        UsernamePasswordAuthenticationToken userNamePAT = TokenUtils.getAuthentication(token);

        // Configura la autenticación en el contexto de seguridad de Spring.
        SecurityContextHolder.getContext().setAuthentication(userNamePAT);

        // Continúa con la siguiente solicitud en la cadena de filtros.
        filterChain.doFilter(request, response);
    }
}
//Este filtro de autorización de JWT verifica si se proporcionó un token de portador válido en la solicitud y, de ser así,
// lo usa para configurar la autenticación en el contexto de seguridad de Spring.
// Si no se proporcionó un token válido, la solicitud y la respuesta se pasan al siguiente filtro en la cadena
// sin realizar ninguna acción adicional.
