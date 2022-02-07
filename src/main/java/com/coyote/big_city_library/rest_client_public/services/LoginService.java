package com.coyote.big_city_library.rest_client_public.services;

import com.coyote.big_city_library.rest_client_public.feign_clients.AuthenticationClient;
import com.coyote.big_city_library.rest_client_public.form_handlers.LoginForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    
    @Autowired
    private AuthenticationClient authClient;

    public String getJWT(LoginForm loginForm) {
        return authClient.getJwt(loginForm);
    }
}
