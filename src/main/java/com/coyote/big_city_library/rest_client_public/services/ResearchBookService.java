package com.coyote.big_city_library.rest_client_public.services;

import java.util.List;

import com.coyote.big_city_library.rest_client_public.dto.BookDto;
import com.coyote.big_city_library.rest_client_public.feign_clients.BookClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResearchBookService {

    @Autowired
    BookClient bookClient;
    
    public List<BookDto> researchBooks(String bookTitle) {
        return bookClient.researchBooks(bookTitle);
    }
}
