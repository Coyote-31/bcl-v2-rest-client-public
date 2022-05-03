package com.coyote.big_city_library.rest_client_public.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.coyote.big_city_library.rest_client_public.dto.search_books.SearchBookDto;
import com.coyote.big_city_library.rest_client_public.form_handlers.SearchBookForm;
import com.coyote.big_city_library.rest_client_public.services.LibraryService;
import com.coyote.big_city_library.rest_client_public.services.SearchBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/recherche")
public class SearchBookController {

    @Autowired
    SearchBookService searchBookService;

    @Autowired
    LibraryService libraryService;

    @GetMapping("")
    public String searchBookForm(Model model) {

        model.addAttribute("search_form", new SearchBookForm());

        return "SearchBookForm";
    }

    @PostMapping("")
    public String searchBookSubmit(HttpSession session, @ModelAttribute SearchBookForm searchBookForm, Model model) {

        log.debug("searchBookSubmit() with {}", searchBookForm.toString());
        model.addAttribute("search_form", searchBookForm);

        List<SearchBookDto> booksFound = searchBookService.searchBooks(searchBookForm);
        log.debug("booksFound.size() = {}", booksFound.size());
        model.addAttribute("books_found", booksFound);

        return "SearchBookForm";
    }

}
