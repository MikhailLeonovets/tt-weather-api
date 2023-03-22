package com.leonovets.ttweatherapi.controller;

import com.leonovets.ttweatherapi.model.dto.WeatherReportDto;
import com.leonovets.ttweatherapi.service.AverageTemperatureService;
import com.leonovets.ttweatherapi.service.crud.WeatherReportCrudService;
import com.leonovets.ttweatherapi.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * RestController contains Weather information endpoints.
 *
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 14:57
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/weather")
public class WeatherReportController {
    private final WeatherReportCrudService weatherReportService;
    private final AverageTemperatureService averageTemperatureService;

    /**
     * Returns response with the newest weather state information.
     *
     * @param location is where you want check weather
     * @return last posted weather report for that location
     * @throws NotFoundException if there is no where report for that location
     */
    @GetMapping("/current")
    public ResponseEntity<?> getCurrentWeatherReport(@RequestParam(
            value = "location",
            required = false,
            defaultValue = "Minsk") final String location) throws NotFoundException {
        return ResponseEntity.ok(WeatherReportDto.createFromEntity(weatherReportService.getLastWeatherReport(location)));
    }

    /**
     * Returns response with the information about average temperatures by date in that period and that location.
     *
     * @param from   is the start date of the period
     * @param to    is the end date of the period
     * @param location is where you want average temperature report for that location
     * @return AverageTemperatureCelsiusDto {@link com.leonovets.ttweatherapi.model.dto.AverageTemperatureCelsiusDto} contains
     *     Average Temperature Celsius by days in that period
     * @throws NotFoundException if there is no any data for that location
     */
    @GetMapping("")
    public ResponseEntity<?> getWeatherAverageWeatherReport(
            @RequestParam(value = "from") @DateTimeFormat(pattern = "dd-MM-yyyy") final Date from,
            @RequestParam(value = "to") @DateTimeFormat(pattern = "dd-MM-yyyy") final Date to,
            @RequestParam(value = "location", required = false, defaultValue = "Minsk") final String location) throws NotFoundException {
        return ResponseEntity.ok(averageTemperatureService.getAverageTemperaturesCelsiusForLocation(from, to, location));
    }
}
