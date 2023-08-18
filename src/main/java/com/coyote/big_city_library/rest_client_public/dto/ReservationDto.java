package com.coyote.big_city_library.rest_client_public.dto;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ReservationDto {

    @NonNull
    private BookDto book;

    @NonNull
    private UserDto user;

    @NonNull
    private ZonedDateTime createdAt;

    private ZonedDateTime notifiedAt;

    private ExemplaryDto exemplary;

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

        // Convert reservations Set to List
        List<ReservationDto> reservations = new ArrayList<>(book.getReservations());

        // Sort by CreatedAt Ascending
        reservations.sort((a, b) -> a.getCreatedAt().compareTo(b.createdAt));

        int count = 1;
        for (ReservationDto reservation : reservations) {
            log.debug("Reservation #{} -> createdAt:{}", count, reservation.getCreatedAt());
            count++;
        }

        return count;
    }
}
