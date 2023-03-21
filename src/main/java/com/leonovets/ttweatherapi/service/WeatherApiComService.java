package com.leonovets.ttweatherapi.service;

import com.leonovets.ttweatherapi.repository.entity.WeatherReport;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 17:39
 */
public interface WeatherApiComService {

    WeatherReport getLastWeatherUpdateFromApi(final String location);

}
