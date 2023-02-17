package com.java.flexilab.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.JwtException;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TokenUtils {

    // Clave secreta para firmar el token
    private final static String ACCESS_TOKEN_SECRET = "ASDBNSDIUFBNASDPIUOFGNAasdasasdJNFIKASJHDNFIUBNASDIPFBN";

    // Tiempo de validez del token (30 días en segundos)
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 30 * 24 * 60 * 60L;

    /**
     * Crea un token JWT con el email y nombre del usuario y lo firma con la clave secreta.
     *
     * @param nombre Nombre del usuario.
     * @param email Email del usuario.
     * @return Token JWT firmado.
     */
    public static String createToken(String nombre, String email) {

        // Se calcula la fecha de expiración sumando el tiempo de validez en milisegundos a la fecha actual.
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        // Se incluye el nombre del usuario como claim adicional.
        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);

        // Se construye y firma el token JWT con la clave secreta.
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(SignatureAlgorithm.HS256, Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    /**
     * Obtiene la autenticación de Spring Security a partir de un token JWT.
     *
     * @param token Token JWT a verificar.
     * @return Objeto de autenticación de Spring Security si el token es válido, o null en caso contrario.
     */
    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            // Se decodifica el token JWT y se obtienen los claims.
            Claims claims = Jwts.parser()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .parseClaimsJws(token)
                    .getBody();

            // Se obtiene el email del usuario a partir del claim "subject".
            String email = claims.getSubject();

            // Se devuelve un objeto de autenticación de Spring Security con el email del usuario.
            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());

        } catch (JwtException e) {
            // Si ocurre algún error al decodificar el token, se devuelve null indicando que la autenticación falló.
            return null;
        }
    }
}
