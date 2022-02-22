package com.coyote.big_city_library.rest_client_public.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.coyote.big_city_library.rest_client_public.dto.search_books.SearchBookDto;
import com.coyote.big_city_library.rest_client_public.feign_clients.BookClient;
import com.coyote.big_city_library.rest_client_public.form_handlers.SearchBookForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchBookService {

    @Autowired
    private BookClient bookClient;

    @Autowired
    private JwtService jwtService;
    
    public List<SearchBookDto> searchBooks(HttpSession session, SearchBookForm searchBookForm) {

        String bearerJwt = jwtService.getBearerJwt(session);

        return bookClient.searchBooks(
            bearerJwt,
            searchBookForm.getBookTitle(), 
            searchBookForm.getAuthorName(), 
            searchBookForm.getPublisherName());

    }
}
