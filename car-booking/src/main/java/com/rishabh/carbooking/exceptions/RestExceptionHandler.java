package com.rishabh.carbooking.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RiderNotFoundException.class})
    public ResponseEntity<Object> handleBadRequest(final RiderNotFoundException e, final WebRequest request) {
        log.error("[RiderNotFound] : {}", e);
        return handleExceptionInternal(e, new ErrorResponse(e.getMessage(), HttpStatus.CONFLICT),
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
    
    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Object> handleBadRequest(final UserNotFoundException e, final WebRequest request) {
        log.error("[UserNotFound] : {}", e);
        return handleExceptionInternal(e, new ErrorResponse(e.getMessage(), HttpStatus.CONFLICT),
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleBadRequest(final RuntimeException e, final WebRequest request) {
        log.error("[RuntimeException] : {}", e);
        return handleExceptionInternal(e, new ErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @Data
    @AllArgsConstructor
    private class ErrorResponse {
        private String message;
        private HttpStatus httpStatus;
    }

}
