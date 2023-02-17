package com.java.flexilab.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Clase de configuración para la seguridad web de la aplicación
 */
@Configuration
@AllArgsConstructor
public class WebSecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;


    /**
     * Constructor vacío para uso en pruebas unitarias
     */
    public WebSecurityConfig() {}

    /**
     * Configura el filtro de seguridad de la aplicación
     * @param http Objeto HttpSecurity para configurar las reglas de seguridad
     * @param authManager AuthenticationManager utilizado para autenticar los usuarios
     * @return SecurityFilterChain configurado
     * @throws Exception si hay un problema al configurar el filtro
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
        // Crear un nuevo filtro de autenticación JWT
        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter(authManager);
        // Configurar el AuthenticationManager para el filtro
        jwtAuthenticationFilter.setAuthenticationManager(authManager);
        // Establecer la URL a la que el filtro procesa la autenticación
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");

        // Configurar HttpSecurity para la aplicación
        return http
                .csrf().disable() // Deshabilitar la protección CSRF
                .authorizeRequests()
                .anyRequest()
                .authenticated() // Cualquier solicitud debe estar autenticada
                .and()
                .httpBasic() // Configurar la autenticación básica
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Configurar la política de creación de sesión
                .and()
                .addFilter(jwtAuthenticationFilter) // Agregar el filtro de autenticación JWT a la cadena de filtros de seguridad
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // Agregar el filtro antes del filtro de autenticación de usuario y contraseña
                .build();
    }

    /**
     * Configura el AuthenticationManager y lo registra como un bean
     * @param http Objeto HttpSecurity utilizado para configurar el AuthenticationManagerBuilder
     * @return AuthenticationManager configurado
     * @throws Exception si hay un problema al configurar el AuthenticationManager
     */
    @Bean
    AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }


    /**
     * Crea un PasswordEncoder y lo registra como un bean
     * @return PasswordEncoder creado
     */
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * Método de prueba para imprimir una contraseña encriptada
     * @param args argumentos de línea de comando (no se utilizan)
     */
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }
}
