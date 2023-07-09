package com.dahlakTechno.demounitTest.model;

import io.jsonwebtoken.*;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTCreatorClass {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Generate Registered Claims
        Map<String, Object> registeredClaims = new HashMap<>();
        registeredClaims.put("sub", "subject"); // Subject claim
        registeredClaims.put("iss", "issuer"); // Issuer claim
        registeredClaims.put("aud", "audience"); // Audience claim

        // Generate Public Claims
        Map<String, Object> publicClaims = new HashMap<>();
        publicClaims.put("username", "username");
        publicClaims.put("password", "password");

        // Generate Private Claims
        Map<String, Object> privateClaims = new HashMap<>();
        privateClaims.put("role", "hr");

        // Create Payload Map
        Map<String, Object> payload = new HashMap<>();
        payload.put("public", publicClaims);
        payload.put("private", privateClaims);
        payload.putAll(registeredClaims);

        // Set expiration time for the token (optional)
        long expirationTimeMillis = System.currentTimeMillis() + 3600000; // 1 hour
        Date expirationDate = new Date(expirationTimeMillis);

        // Create JWT Header
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");

        // Generate the JWT
        JwtBuilder jwtBuilder = Jwts.builder()
                .setHeader(header)
                .setClaims(payload)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secreteKeyGenerator());

        // Serialize to compact form
        String jwt = jwtBuilder.compact();

        System.out.println("Bearer " + jwt);

    }
    private static String secreteKeyGenerator() throws NoSuchAlgorithmException {
        SecretKey secretKey = KeyGenerator.getInstance("HmacSHA256").generateKey();
        if (secretKey != null) {
            String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            System.out.println("Generated Secret Key: " + encodedKey);
            return encodedKey;

        }
        return null;
    }
}
