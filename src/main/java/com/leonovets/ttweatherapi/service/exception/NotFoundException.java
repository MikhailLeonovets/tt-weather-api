package com.leonovets.ttweatherapi.service.exception;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 20:18
 */
public class NotFoundException extends Exception {
    public NotFoundException(final String message) {
        super(message);
    }
}
