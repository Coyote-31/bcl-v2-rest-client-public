package com.coyote.big_city_library.rest_client_public.feign_clients.errors.exceptions;

public class RestApiClientException extends Exception {

    public RestApiClientException(String errorMessage) {
        super(errorMessage);
    }
}
