package com.coyote.big_city_library.rest_client_public.feign_clients.errors;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;

import com.coyote.big_city_library.rest_client_public.feign_clients.errors.exceptions.ForbiddenException;
import com.coyote.big_city_library.rest_client_public.feign_clients.errors.exceptions.RestApiServerException;
import com.coyote.big_city_library.rest_client_public.feign_clients.errors.exceptions.UnauthorizedException;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {

        String errorMessage = "4xx client error";
        HttpStatus responseStatus = HttpStatus.valueOf(response.status());

        try {
            errorMessage = new BufferedReader(response.body().asReader(StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            log.error("IOException", e);
        }

        if (responseStatus.is5xxServerError()) {
            return new RestApiServerException(errorMessage);
        }

        switch (response.status()) {

            case 401:
                return new UnauthorizedException(errorMessage);
            case 403:
                return new ForbiddenException(errorMessage);
            case 404:
                return new FileNotFoundException(errorMessage);

            default:
                return errorDecoder.decode(methodKey, response);
        }

    }
}
