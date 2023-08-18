package com.coyote.big_city_library.rest_client_public.feign_clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.coyote.big_city_library.rest_client_public.dto.ReservationDto;
import com.coyote.big_city_library.rest_client_public.dto.reservation.my.MyReservationDto;

@FeignClient(name = "BigCityLibrary-RestServer-reservation", url = "${feign_clients.url}", path = "/api/reservations")
public interface ReservationClient {

        @GetMapping("/user/{pseudo}")
        List<MyReservationDto> findReservationsByUserPseudo(
                        @RequestHeader("Authorization") String bearerJwt,
                        @PathVariable String pseudo);

        @PostMapping("/add")
        ReservationDto addReservation(
                        @RequestHeader("Authorization") String bearerJwt,
                        @RequestParam Integer bookId);

        @DeleteMapping("/delete")
        void deleteReservationById(
                        @RequestHeader("Authorization") String bearerJwt,
                        @RequestParam Integer bookId,
                        @RequestParam Integer userId);

}
