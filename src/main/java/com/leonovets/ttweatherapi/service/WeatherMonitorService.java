package com.leonovets.ttweatherapi.service;

/**
 * Interface contains methods to start monitoring weather from the Third Party Application
 * and store that information.
 *
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 20:29
 */
public interface WeatherMonitorService {
    /**
     * Starts weather monitoring.
     *
     * @param location is location where you want to get weather state
     */
    void doMonitoringForLocation(final String location);
}
