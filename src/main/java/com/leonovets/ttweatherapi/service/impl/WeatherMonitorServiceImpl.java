package com.leonovets.ttweatherapi.service.impl;

import com.leonovets.ttweatherapi.service.WeatherMonitorService;
import com.leonovets.ttweatherapi.service.WeatherStateCallerService;
import com.leonovets.ttweatherapi.service.crud.WeatherReportCrudService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 20:31
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class WeatherMonitorServiceImpl implements WeatherMonitorService {
    private final WeatherReportCrudService weatherReportCrudService;
    private final WeatherStateCallerService weatherStateCallerService;

    @Override
    public void doMonitoringForLocation(final String location) {
        weatherReportCrudService.save(weatherStateCallerService.getLastWeatherUpdateFromApi(location));
    }
}
