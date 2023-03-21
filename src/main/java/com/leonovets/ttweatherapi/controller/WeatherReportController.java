package com.leonovets.ttweatherapi.controller;

import com.leonovets.ttweatherapi.service.WeatherReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 14:57
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/weather")
public class WeatherReportController {
    private final WeatherReportService weatherReportService;

    @GetMapping("/current")
    public ResponseEntity<?> getCurrentWeatherReport() {
        return ResponseEntity.ok(""); //TODO
    }

    @GetMapping("")
    public ResponseEntity<?> getWeatherAverageWeatherReport() {
        return ResponseEntity.ok(""); //TODO
    }
}
