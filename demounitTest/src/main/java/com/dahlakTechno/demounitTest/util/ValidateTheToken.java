package com.dahlakTechno.demounitTest.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Map;
import java.util.logging.Logger;

public class ValidateTheToken {
    private static final Logger logger = Logger.getLogger(ValidateTheToken.class.getName());
    public boolean isValidateToken(String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            logger.info("Token is null or does not start with 'Bearer'");
            return false;
        }

        String jwtToken = token.substring(7); // Remove the "Bearer " prefix
        try {

            Claims claims = Jwts.parser()
                    .setSigningKey("oj2Di/CQpAffyQNihEzKovL3Uc/mEeFzpd9256FtWTo=")
                    .parseClaimsJws(jwtToken)
                    .getBody();

            logger.info("Checking if the token has a subject claim");
            if (claims.getSubject() == null) {
                return false;
            }

            logger.info("Validating the token issuer and audience");
            String issuer = claims.getIssuer();
            String audience = claims.getAudience();
            if (!"issuer".equals(issuer) || !"audience".equals(audience)) {
                return false;
            }

            logger.info("Validating the custom claims (public and private)");
            Map<String, Object> publicClaims = claims.get("public", Map.class);
            Map<String, Object> privateClaims = claims.get("private", Map.class);

            logger.info("Checking if the public claims contain the required fields (username and password)");
            if (!isValidPublicClaims(publicClaims)) {
                return false;
            }

            logger.info("Checking if the private claims contain the required field (role)");
            if (!isValidPrivateClaims(privateClaims)) {
                return false;
            }

            logger.info("All checks pass. The token is considered valid");
            return true;
        } catch (Exception e) {
            logger.info("An exception during token parsing or validation means the token is invalid");
            return false;
        }
    }

    private boolean isValidPublicClaims(Map<String, Object> publicClaims) {
        return publicClaims != null &&
                publicClaims.containsKey("username") &&
                publicClaims.containsKey("password");
    }

    private boolean isValidPrivateClaims(Map<String, Object> privateClaims) {
        return privateClaims != null && privateClaims.containsKey("role");
    }
}
