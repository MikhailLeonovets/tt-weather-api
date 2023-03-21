package com.leonovets.ttweatherapi.service;

import com.leonovets.ttweatherapi.repository.entity.WeatherReport;
import com.leonovets.ttweatherapi.service.exception.NotFoundException;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 14:56
 */
public interface WeatherReportCrudService {
    WeatherReport save(final WeatherReport weatherReport);

    WeatherReport getLastWeatherReport(final String location) throws NotFoundException;
}
