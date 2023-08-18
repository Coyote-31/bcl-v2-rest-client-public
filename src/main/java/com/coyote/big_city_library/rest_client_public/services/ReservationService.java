package com.coyote.big_city_library.rest_client_public.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coyote.big_city_library.rest_client_public.dto.ReservationDto;
import com.coyote.big_city_library.rest_client_public.dto.reservation.my.MyReservationDto;
import com.coyote.big_city_library.rest_client_public.feign_clients.ReservationClient;

@Service
public class ReservationService {

    @Autowired
    private ReservationClient reservationClient;

    @Autowired
    private JwtService jwtService;

    public List<MyReservationDto> findReservationsByUserPseudo(HttpSession session, String pseudo) {

        String bearerJwt = jwtService.getBearerJwt(session);

        return reservationClient.findReservationsByUserPseudo(bearerJwt, pseudo);
    }

    public ReservationDto addReservation(
            HttpSession session,
            Integer bookId) {

        String bearerJwt = jwtService.getBearerJwt(session);

        return reservationClient.addReservation(bearerJwt, bookId);
    }

    public void deleteReservationById(HttpSession session,
            Integer bookId,
            Integer userId) {

        String bearerJwt = jwtService.getBearerJwt(session);

        reservationClient.deleteReservationById(bearerJwt, bookId, userId);
    }

}
