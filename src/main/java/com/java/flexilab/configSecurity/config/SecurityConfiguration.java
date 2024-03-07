package com.java.flexilab.configSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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

import lombok.AllArgsConstructor;

/**
 * Configuración de seguridad para la aplicación.
 */
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration {

    private final UserDetailsService userDetailsService;
    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    /**
     * Configura y devuelve el AuthenticationManager.
     *
     * @param http La configuración HttpSecurity.
     * @return El AuthenticationManager configurado.
     * @throws Exception Si ocurre un error durante la configuración.
     */
    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http
                .getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    /**
     * Configura y devuelve el SecurityFilterChain.
     *
     * @param http         La configuración HttpSecurity.
     * @param authManager  El AuthenticationManager.
     * @return El SecurityFilterChain configurado.
     * @throws Exception Si ocurre un error durante la configuración.
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
        jwtAuthenticationFilter.setAuthenticationManager(authManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/api/v1/login");

        return http
                .csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                .requestMatchers("/signup").permitAll()
                .requestMatchers("/login").permitAll()
                //.requestMatchers(HttpMethod.GET, "/api/v1/categorias").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .requestMatchers(request -> "/api/v1/categorias".equals(request.getRequestURI())).permitAll() // Permitir acceso sin autenticación
                .requestMatchers(request -> "/api/v1/clases/page".equals(request.getRequestURI())).permitAll() // Permitir acceso sin autenticación
                .requestMatchers(request -> "/api/v1/clases/filtrar".equals(request.getRequestURI())).permitAll() // Permitir acceso sin autenticación
                .requestMatchers(request -> "/api/v1/producto/page".equals(request.getRequestURI())).permitAll() // Permitir acceso sin autenticación
                .requestMatchers(request -> "/api/v1/producto/filtrar".equals(request.getRequestURI())).permitAll() // Permitir acceso sin autenticación
                .requestMatchers(request -> "/api/v1/categoriasProducto".equals(request.getRequestURI())).permitAll() // Permitir acceso sin autenticación
                .requestMatchers(request -> "PUT".equals(request.getMethod()) && request.getRequestURI().matches("/api/v1/clases/\\d+/sumarVisita")).permitAll() // Permitir acceso sin autenticación para el método PUT
                .requestMatchers("/api/v1/usuarios/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .requestMatchers("/api/v1/admins/**").hasAnyAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(jwtAuthorizationFilter, JWTAuthenticationFilter.class)
                .build();
    }

    /**
     * Crea un codificador de contraseñas.
     *
     * @return El PasswordEncoder creado.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}