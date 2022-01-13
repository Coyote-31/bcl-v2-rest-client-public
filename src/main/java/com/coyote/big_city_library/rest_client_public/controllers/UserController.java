package com.coyote.big_city_library.rest_client_public.controllers;

import java.util.List;

import com.coyote.big_city_library.rest_client_public.dto.UserDto;
import com.coyote.big_city_library.rest_client_public.feign_clients.UserClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserClient userClient;
    
    @GetMapping("")
    public List<UserDto> findAllUsers() {
        List<UserDto> users = userClient.findAllUsers();
        log.debug("findAllUsers() => {} user(s) found", users.size());
        return users;
    }

}
