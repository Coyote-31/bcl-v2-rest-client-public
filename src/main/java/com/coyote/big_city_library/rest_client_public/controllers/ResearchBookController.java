package com.coyote.big_city_library.rest_client_public.controllers;

import java.util.List;

import com.coyote.big_city_library.rest_client_public.dto.BookDto;
import com.coyote.big_city_library.rest_client_public.form_handlers.ResearchBookForm;
import com.coyote.big_city_library.rest_client_public.services.ResearchBookService;

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
public class ResearchBookController {

    @Autowired
    ResearchBookService researchBookService;
    
    @GetMapping("")
    public String researchBookForm(Model model) {

        model.addAttribute("research_form", new ResearchBookForm());

        return "ResearchBookForm";
    }

    @PostMapping("")
    public String researchBookSubmit(@ModelAttribute ResearchBookForm researchBookForm, Model model) {

        log.debug("researchBookSubmit() with {}", researchBookForm.toString());
        model.addAttribute("research_form", researchBookForm);

        List<BookDto> booksFound = researchBookService.researchBooks(researchBookForm.getBookTitle());
        log.debug("booksFound.size() = {}", booksFound.size());
        model.addAttribute("books_found", booksFound);

        return "ResearchBookForm";
    }

}
