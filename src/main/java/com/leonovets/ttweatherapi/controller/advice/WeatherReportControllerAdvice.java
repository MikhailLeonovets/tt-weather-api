package com.leonovets.ttweatherapi.controller.advice;

import com.leonovets.ttweatherapi.service.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Mikhail.Leonovets
 * @since 03/22/2023 - 16:56
 */
@Slf4j
@ControllerAdvice
public class WeatherReportControllerAdvice {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(final NotFoundException e) {
        log.warn(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
