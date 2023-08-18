package com.coyote.big_city_library.rest_client_public.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.coyote.big_city_library.rest_client_public.dto.reservation.my.MyReservationDto;
import com.coyote.big_city_library.rest_client_public.services.ReservationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mes-reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("")
    public String getUserReservations(HttpSession session, Model model) {

        // If session doesn't exist -> 401
        if (session == null || session.getAttribute("pseudo") == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        List<MyReservationDto> reservations = reservationService.findReservationsByUserPseudo(
                session,
                session.getAttribute("pseudo").toString());

        model.addAttribute("reservations", reservations);

        return "UserReservations";
    }

    @PostMapping("/add")
    public String addReservation(
            HttpSession session,
            @RequestParam Integer bookId) {

        // If session doesn't exist -> 401
        if (session == null || session.getAttribute("pseudo") == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        log.debug("Add reservation on bookId:{} for user:{}", bookId, session.getAttribute("pseudo"));

        reservationService.addReservation(session, bookId);

        return "redirect:/mes-reservations";

    }

    @DeleteMapping("/delete")
    public String deleteReservationById(
            HttpSession session,
            @RequestParam Integer bookId,
            @RequestParam Integer userId) {

        // If session doesn't exist -> 401
        if (session == null || session.getAttribute("pseudo") == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        log.debug("Delete reservation send for bookId:{} and userId:{}", bookId, userId);

        reservationService.deleteReservationById(session, bookId, userId);

        return "redirect:/mes-reservations";
    }

}
