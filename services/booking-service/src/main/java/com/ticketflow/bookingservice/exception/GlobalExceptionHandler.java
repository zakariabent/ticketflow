
package com.ticketflow.bookingservice.exception;

import feign.FeignException;
import feign.RetryableException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<Map<String, Object>> handleEventNotFound(
            FeignException.NotFound exception) {

        Map<String, Object> response = Map.of(
                "status", 404,
                "error", "Event not found"
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler({
            RetryableException.class,
            CallNotPermittedException.class,
            NoFallbackAvailableException.class
    })
    public ResponseEntity<Map<String, Object>> handleServiceUnavailable(
            Exception exception) {

        Map<String, Object> response = Map.of(
                "status", 503,
                "error", "Event service unavailable"
        );

        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(response);
    }
}
