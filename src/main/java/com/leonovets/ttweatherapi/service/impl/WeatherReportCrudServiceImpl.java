package com.leonovets.ttweatherapi.service.impl;

import com.leonovets.ttweatherapi.repository.WeatherReportRepository;
import com.leonovets.ttweatherapi.repository.entity.WeatherReport;
import com.leonovets.ttweatherapi.service.WeatherReportCrudService;
import com.leonovets.ttweatherapi.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 20:03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class WeatherReportCrudServiceImpl implements WeatherReportCrudService {
    private final WeatherReportRepository weatherReportRepository;

    @Override
    public WeatherReport save(final WeatherReport weatherReport) {
        log.info("Saving weather report");
        return weatherReportRepository.save(weatherReport);
    }

    @Override
    public WeatherReport getLastWeatherReport(final String location) throws NotFoundException {
        return weatherReportRepository.findNewestWeatherReportByLocation(location).orElseThrow(
                () -> new NotFoundException(String.format("Weather report not found for '%s'", location))
        );
    }
}
