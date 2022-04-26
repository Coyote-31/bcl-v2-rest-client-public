package com.coyote.big_city_library.rest_client_public.feign_clients;

import java.util.List;

import com.coyote.big_city_library.rest_client_public.dto.search_books.SearchBookDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "BigCityLibrary-RestServer-book", url = "${feign_clients.url}", path = "/api/books")
public interface BookClient {

    @PostMapping("/search")
    List<SearchBookDto> searchBooks(
            @RequestParam("bookTitle") String bookTitle,
            @RequestParam("authorName") String authorName,
            @RequestParam("publisherName") String publisherName);

}
