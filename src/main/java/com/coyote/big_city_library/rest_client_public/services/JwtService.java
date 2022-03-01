package com.coyote.big_city_library.rest_client_public.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;

@Service
public class JwtService {

    @Value("${security.jwt.secretKey}")
    private String jwtSecretKey = "secret";

    public String getBearerJwt(HttpSession session) {

        Object oJWT = session.getAttribute("jwt");
        String jwt = null;
        String bearerJwt = null;

        if (oJWT != null) {
            jwt = oJWT.toString();
            bearerJwt = "Bearer " + jwt;
    
        } else {
            throw new NullPointerException("jwt cannot be null");
        }

        return bearerJwt;
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(token).getBody().getSubject();
    }

	public String getRole(String token) {
		return Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(token).getBody().get("role").toString();
	}
    
}
