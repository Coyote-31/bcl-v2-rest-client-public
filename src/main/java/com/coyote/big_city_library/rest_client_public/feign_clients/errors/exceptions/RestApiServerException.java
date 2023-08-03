package com.coyote.big_city_library.rest_client_public.feign_clients.errors.exceptions;

public class RestApiServerException extends Exception {

    public RestApiServerException(String errorMessage) {
        super(errorMessage);
    }
}
