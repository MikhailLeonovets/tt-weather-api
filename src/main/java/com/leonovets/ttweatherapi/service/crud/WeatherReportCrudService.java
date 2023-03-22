package com.leonovets.ttweatherapi.service.crud;

import com.leonovets.ttweatherapi.repository.entity.WeatherReport;
import com.leonovets.ttweatherapi.service.exception.NotFoundException;

import java.util.Date;
import java.util.List;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 14:56
 */
public interface WeatherReportCrudService {
    WeatherReport save(final WeatherReport weatherReport);

    WeatherReport getLastWeatherReport(final String location) throws NotFoundException;

    List<WeatherReport> getWeatherReportsByPeriodAndLocation(final Date from,
                                                             final Date to,
                                                             final String location) throws NotFoundException;
}
