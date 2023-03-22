package com.leonovets.ttweatherapi.service.exception;

/**
 * Used to be an Exception if we have an Error while using Weather Api via Rapid Api.
 *
 * @author Mikhail.Leonovets
 * @since 03/22/2023 - 14:25
 */
public class WeatherApiException extends RuntimeException {
    /**
     * Constructor with exception message.
     * Calls super class.
     *
     * @param message is the message of Exception
     */
    public WeatherApiException(final String message) {
        super(message);
    }
}
