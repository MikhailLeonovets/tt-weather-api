package com.leonovets.ttweatherapi.controller.advice;

import com.leonovets.ttweatherapi.service.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controller Advice to catch any NotFoundException {@link com.leonovets.ttweatherapi.service.exception.NotFoundException}
 * thrown by the application.
 *
 * @author Mikhail.Leonovets
 * @since 03/22/2023 - 16:56
 */
@Slf4j
@ControllerAdvice
public class WeatherReportControllerAdvice {
    /**
     * Method to catch any NotFoundException {@link com.leonovets.ttweatherapi.service.exception.NotFoundException}
     * thrown by the application.
     *
     * @param exception NotFound Exception to be caught
     * @return ResponseEntity with 404 HttpStatus and exception message in the body
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(final NotFoundException exception) {
        log.warn(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
