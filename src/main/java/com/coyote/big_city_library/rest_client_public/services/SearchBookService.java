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
    
    public List<SearchBookDto> searchBooks(HttpSession httpSession, SearchBookForm searchBookForm) {

        Object oJWT = httpSession.getAttribute("jwt");
        String jwt = null;
        String bearerJwt = null;

        if (oJWT != null) {
            jwt = oJWT.toString();

            bearerJwt = "Bearer " + jwt;
    
            return bookClient.searchBooks(
                bearerJwt,
                searchBookForm.getBookTitle(), 
                searchBookForm.getAuthorName(), 
                searchBookForm.getPublisherName());
        } else {
            throw new IllegalArgumentException("jwt cannot be null");
        }

    }
}
