package com.coyote.big_city_library.rest_client_public.feign_clients;

import java.util.List;

import com.coyote.big_city_library.rest_client_public.dto.BookDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "BigCityLibrary-RestServer-book", url = "localhost:9001", path = "/api/books")
public interface BookClient {
    
    @GetMapping("/search")
    List<BookDto> searchBooks(
        @RequestParam("bookTitle") String bookTitle,
        @RequestParam("authorName") String authorName,
        @RequestParam("publisherName") String publisherName);
    
}