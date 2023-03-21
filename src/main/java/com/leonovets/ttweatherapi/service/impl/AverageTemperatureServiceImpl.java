package com.leonovets.ttweatherapi.service.impl;

import com.leonovets.ttweatherapi.model.dto.AverageTemperaturesCelsiusDto;
import com.leonovets.ttweatherapi.repository.WeatherReportRepository;
import com.leonovets.ttweatherapi.repository.entity.WeatherReport;
import com.leonovets.ttweatherapi.service.AverageTemperatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 21:12
 */
@RequiredArgsConstructor
@Service
public class AverageTemperatureServiceImpl implements AverageTemperatureService {
    private final WeatherReportRepository weatherReportRepository;

    @Override
    public List<AverageTemperaturesCelsiusDto> getAverageTemperaturesCelsiusForLocation(final Date from,
                                                                                        final Date to,
                                                                                        final String location) {
        final List<WeatherReport> weatherReports = weatherReportRepository.getTemperatureByPeriod(from, to, location);
        final Map<Date, List<WeatherReport>> groups = groupWeatherReportsByDate(weatherReports);
        return calculateAverageTemperature(groups);
    }

    private Map<Date, List<WeatherReport>> groupWeatherReportsByDate(final List<WeatherReport> weatherReports) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return weatherReports.stream()
                .collect(Collectors.groupingBy(weatherReport -> {
                    try {
                        return simpleDateFormat.parse(simpleDateFormat.format(weatherReport.getPostDate()));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }));
    }

    private List<AverageTemperaturesCelsiusDto> calculateAverageTemperature(final Map<Date, List<WeatherReport>> groups) {
        final List<AverageTemperaturesCelsiusDto> result = new ArrayList<>();
        for (final Map.Entry<Date, List<WeatherReport>> group : groups.entrySet()) {
            result.add(new AverageTemperaturesCelsiusDto(group.getValue().stream()
                    .mapToDouble(WeatherReport::getTemperatureCelsius)
                    .average()
                    .orElse(Double.NaN), group.getKey()));
        }
        return result;
    }
}
