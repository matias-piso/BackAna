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
    private final static String ACCES_TOKEN_SECRET = "ASDBNSDIUFBNASDPIUOFGNAasdasasdJNFIKASJHDNFIUBNASDIPFBN";
    private final static Long   ACCES_TOKEN_VALIDITY_SECONDS = Long.valueOf("2.592.000L");

    public   static  String createToken(String nombre, String email){
        long expirationTime = ACCES_TOKEN_VALIDITY_SECONDS * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map <String,Object> extra = new HashMap<>();
            extra.put("nombre",nombre);


        return  Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(SignatureAlgorithm.HS256, Keys.hmacShaKeyFor(ACCES_TOKEN_SECRET.getBytes()))
                .compact();
    }
    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(ACCES_TOKEN_SECRET.getBytes())
                    .parseClaimsJws(token)
                    .getBody();
            String email = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        }catch (JwtException e){
            return null;
        }
    }

}
