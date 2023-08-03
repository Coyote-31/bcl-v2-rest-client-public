package com.coyote.big_city_library.rest_client_public.feign_clients.errors.exceptions;

public class ForbiddenException extends Exception {

    public ForbiddenException(String errorMessage) {
        super(errorMessage);
    }
}
