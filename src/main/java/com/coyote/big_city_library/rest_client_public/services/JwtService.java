package com.coyote.big_city_library.rest_client_public.services;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class JwtService {

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
    
}
