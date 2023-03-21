package com.leonovets.ttweatherapi.service;

import com.leonovets.ttweatherapi.repository.entity.WeatherReport;

import java.util.Date;
import java.util.List;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 14:56
 */
public interface WeatherReportService {
    WeatherReport save(final WeatherReport weatherReport);

    WeatherReport getCurrent();

    List<WeatherReport> getByPeriod(final Date from, final Date to);
}
