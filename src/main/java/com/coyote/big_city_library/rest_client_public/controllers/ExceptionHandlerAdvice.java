package com.coyote.big_city_library.rest_client_public.controllers;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.coyote.big_city_library.rest_client_public.feign_clients.errors.exceptions.ForbiddenException;
import com.coyote.big_city_library.rest_client_public.feign_clients.errors.exceptions.RestApiClientException;
import com.coyote.big_city_library.rest_client_public.feign_clients.errors.exceptions.RestApiServerException;
import com.coyote.big_city_library.rest_client_public.feign_clients.errors.exceptions.UnauthorizedException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {

    private static final String ERROR_MSG = "errorMessage";

    @ExceptionHandler(RestApiClientException.class)
    public String handleRestApiClientException(RestApiClientException e, Model model) {

        log.warn("RestApiClientException : {}", e.getMessage());

        model.addAttribute(ERROR_MSG, e.getMessage());

        return "error";
    }

    @ExceptionHandler(RestApiServerException.class)
    public String handleUserAccessDeniedException(RestApiServerException e, Model model) {

        log.warn("RestApiServerException : {}", e.getMessage());

        model.addAttribute(ERROR_MSG, e.getMessage());

        return "error";
    }

    // 401 - HttpStatus.UNAUTHORIZED
    @ExceptionHandler(UnauthorizedException.class)
    public String handleUnauthorizedException(UnauthorizedException e, Model model) {

        log.warn("UnauthorizedException : {}", e.getMessage());

        model.addAttribute(ERROR_MSG, e.getMessage());

        return "error/401";
    }

    // 403 - HttpStatus.FORBIDDEN
    @ExceptionHandler(ForbiddenException.class)
    public String handleForbiddenException(ForbiddenException e, Model model) {

        log.warn("ForbiddenException : {}", e.getMessage());

        model.addAttribute(ERROR_MSG, e.getMessage());

        return "error/403";
    }

    // 404 - HttpStatus.NOT_FOUND
    @ExceptionHandler(FileNotFoundException.class)
    public String handleFileNotFoundException(FileNotFoundException e, Model model) {

        log.warn("FileNotFoundException : {}", e.getMessage());

        model.addAttribute(ERROR_MSG, e.getMessage());

        return "error/404";
    }
}
