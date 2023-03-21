package com.leonovets.ttweatherapi.service;

import com.leonovets.ttweatherapi.model.dto.AverageTemperaturesCelsiusDto;

import java.util.Date;
import java.util.List;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 21:10
 */
public interface AverageTemperatureService {

    List<AverageTemperaturesCelsiusDto> getAverageTemperaturesCelsiusForLocation(final Date from, final Date to, final String location);

}
