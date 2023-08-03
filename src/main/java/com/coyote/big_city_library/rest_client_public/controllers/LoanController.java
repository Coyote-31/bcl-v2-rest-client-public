package com.coyote.big_city_library.rest_client_public.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import com.coyote.big_city_library.rest_client_public.dto.LoanDto;
import com.coyote.big_city_library.rest_client_public.services.LoanService;

@Controller
@RequestMapping("/mes-prets")
public class LoanController {

    @Autowired
    LoanService loanService;

    @GetMapping("")
    public String getUserLoans(HttpSession session, Model model) {

        // If session doesn't exist -> 401
        if (session == null || session.getAttribute("pseudo") == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        List<LoanDto> loans = loanService.findLoansByUserPseudo(session, session.getAttribute("pseudo").toString());

        model.addAttribute("loans", loans);
        model.addAttribute("localDateNow", LocalDate.now());

        return "UserLoans";
    }

    @GetMapping("/etendre/{id}")
    public String extendLoan(HttpSession session, @PathVariable Integer id) {

        // If session doesn't exist -> 401
        if (session == null || session.getAttribute("pseudo") == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        loanService.extendLoan(session, id);

        return "redirect:/mes-prets";
    }

}
