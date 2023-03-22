package com.leonovets.ttweatherapi.service.crud;

import com.leonovets.ttweatherapi.repository.entity.WeatherReport;
import com.leonovets.ttweatherapi.service.exception.NotFoundException;

import java.util.Date;
import java.util.List;

/**
 * Service to be used as a CRUD service for WeatherReport Entity {@link com.leonovets.ttweatherapi.repository.entity.WeatherReport}.
 *
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 14:56
 */
public interface WeatherReportCrudService {

    /**
     * Saves WeatherReport.
     *
     * @param weatherReport to be saved
     * @return updated WeatherReport after saving
     */
    WeatherReport save(final WeatherReport weatherReport);

    /**
     * Get the newest WeatherReport stored for that location.
     *
     * @param location it from weatherReport you want
     * @return the newest WeatherReport stored
     * @throws NotFoundException if there is no weather report in that location
     */
    WeatherReport getLastWeatherReport(final String location) throws NotFoundException;

    /**
     * Get List of WeatherReports stored in that period and in that location.
     *
     * @param from     start date of period
     * @param to       end date of period
     * @param location is from location you want weatherReport
     * @return List of Weather Reports which have postDate in that period and needed location
     * @throws NotFoundException if there is no weatherReport in that period and location stored
     */
    List<WeatherReport> getWeatherReportsByPeriodAndLocation(final Date from,
                                                             final Date to,
                                                             final String location) throws NotFoundException;
}
