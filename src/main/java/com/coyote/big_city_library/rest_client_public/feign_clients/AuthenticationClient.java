package com.coyote.big_city_library.rest_client_public.feign_clients;

import com.coyote.big_city_library.rest_client_public.form_handlers.LoginForm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "BigCityLibrary-RestServer-authentication", url = "localhost:9001", path = "/api/auth")
public interface AuthenticationClient {
    
    @PostMapping("/login")
    String getJwt(@RequestBody LoginForm loginForm);
    
}