package com.coyote.big_city_library.rest_client_public.services;

import java.util.List;

import com.coyote.big_city_library.rest_client_public.dto.BookDto;
import com.coyote.big_city_library.rest_client_public.feign_clients.BookClient;
import com.coyote.big_city_library.rest_client_public.form_handlers.SearchBookForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchBookService {

    @Autowired
    BookClient bookClient;
    
    public List<BookDto> searchBooks(SearchBookForm searchBookForm) {
        return bookClient.searchBooks(
            searchBookForm.getBookTitle(), 
            searchBookForm.getAuthorName(), 
            searchBookForm.getPublisherName());
    }
}
