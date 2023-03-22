package com.leonovets.ttweatherapi.service;

import com.leonovets.ttweatherapi.model.dto.AverageTemperatureCelsiusDto;
import com.leonovets.ttweatherapi.service.exception.NotFoundException;

import java.util.Date;
import java.util.List;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 21:10
 */
public interface AverageTemperatureService {

    List<AverageTemperatureCelsiusDto> getAverageTemperaturesCelsiusForLocation(final Date from, final Date to, final String location) throws NotFoundException;

}
