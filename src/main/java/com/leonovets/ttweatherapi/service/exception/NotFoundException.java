package com.leonovets.ttweatherapi.service.exception;

/**
 * Used for Exceptions if there is no needed data stored.
 *
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 20:18
 */
public class NotFoundException extends Exception {
    /**
     * Constructor with exception message.
     * Calls super class.
     *
     * @param message is the message of Exception
     */
    public NotFoundException(final String message) {
        super(message);
    }
}
