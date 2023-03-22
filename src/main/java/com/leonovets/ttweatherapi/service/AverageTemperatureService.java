package com.leonovets.ttweatherapi.service;

import com.leonovets.ttweatherapi.model.dto.AverageTemperatureCelsiusDto;
import com.leonovets.ttweatherapi.service.exception.NotFoundException;

import java.util.Date;
import java.util.List;

/**
 * Interface of the Service includes methods to get Average Temperatures.
 *
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 21:10
 */
public interface AverageTemperatureService {

    /**
     * Calculates average temperatures fot that period and that location.
     *
     * @param from     start date of period
     * @param to       end date of period
     * @param location is from location you want to get Average Temperature Information
     * @return List of AverageTemperatureCelsiusDto contains average temperatures by date
     * @throws NotFoundException if there is no information in that period and that location
     */
    List<AverageTemperatureCelsiusDto> getAverageTemperaturesCelsiusForLocation(final Date from, final Date to, final String location)
            throws NotFoundException;

}
