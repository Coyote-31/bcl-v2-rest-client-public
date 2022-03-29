package com.coyote.big_city_library.rest_client_public.feign_clients;

import java.util.List;

import com.coyote.big_city_library.rest_client_public.dto.LibraryDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "BigCityLibrary-RestServer-library", url = "localhost:9001", path = "/api/libraries")
public interface LibraryClient {

    @GetMapping("")
    List<LibraryDto> findAllLibraries(@RequestHeader("Authorization") String bearerJwt);

}
