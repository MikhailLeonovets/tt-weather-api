package com.leonovets.ttweatherapi.service;

import com.leonovets.ttweatherapi.repository.entity.WeatherReport;

/**
 * Interface contains methods to get weather state from the Third Party Application.
 *
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 17:39
 */
public interface WeatherStateCallerService {
    /**
     * Gets weather state information from the Third Party Application.
     *
     * @param location is from location you want to store weather state information
     * @return WeatherReport from this location.
     */
    WeatherReport getLastWeatherUpdateFromApi(final String location);

}
