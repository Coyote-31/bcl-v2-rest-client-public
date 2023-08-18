package com.coyote.big_city_library.rest_client_public.dto.reservation.my;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@Getter
@Setter
public class MyReservationDto {

    private MyBookDto book;

    private MyUserDto user;

    private ZonedDateTime createdAt;

    private ZonedDateTime notifiedAt;

    private MyExemplaryDto exemplary;

    /*
     * Getters for dates in Europe/Paris TZ
     */

    public ZonedDateTime getCreatedAt() {
        return createdAt.withZoneSameInstant(ZoneId.of("Europe/Paris"));
    }

    public ZonedDateTime getNotifiedAt() {
        return notifiedAt.withZoneSameInstant(ZoneId.of("Europe/Paris"));
    }

    /**
    * Utilities getters
    */

    public Integer getReservationsSize() {
        return book.getReservations().size();
    }

    public Integer getUserReservationPosition() {

        log.debug("getUserReservationPosition for book='{}' :", book.getTitle());

        // Convert reservations Set to List
        List<MyReservationInBookDto> reservations = new ArrayList<>(book.getReservations());

        // Sort by CreatedAt Ascending
        reservations.sort((a, b) -> a.getCreatedAt().compareTo(b.getCreatedAt()));

        int count = 0;
        int position = 0;

        for (MyReservationInBookDto reservation : reservations) {
            count++;
            log.debug("Reservation #{} -> createdAt:{}", count, reservation.getCreatedAt());

            // If its the owning reservation user copy the position
            if (reservation.getUser().getId().equals(user.getId())) {
                position = count;
            }
        }

        return position;
    }
}
