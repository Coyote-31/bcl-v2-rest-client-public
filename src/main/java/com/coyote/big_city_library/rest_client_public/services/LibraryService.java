package com.coyote.big_city_library.rest_client_public.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.coyote.big_city_library.rest_client_public.dto.LibraryDto;
import com.coyote.big_city_library.rest_client_public.feign_clients.LibraryClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    @Autowired
    private LibraryClient libraryClient;

    @Autowired
    private JwtService jwtService;

    public List<LibraryDto> findAllLibraries(HttpSession session) {

        String bearerJwt = jwtService.getBearerJwt(session);

        return libraryClient.findAllLibraries(bearerJwt);

    }
}
