package com.leonovets.ttweatherapi.service.exception;

/**
 * @author Mikhail.Leonovets
 * @since 03/22/2023 - 14:25
 */
public class WeatherApiException extends RuntimeException {
    public WeatherApiException(final String message) {
        super(message);
    }
}
