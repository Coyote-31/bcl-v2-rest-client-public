package com.coyote.big_city_library.rest_client_public.feign_clients.errors.exceptions;

public class UnauthorizedException extends Exception {

    public UnauthorizedException(String errorMessage) {
        super(errorMessage);
    }
}
