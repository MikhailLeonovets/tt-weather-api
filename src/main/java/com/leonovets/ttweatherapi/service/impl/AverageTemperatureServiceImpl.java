package com.leonovets.ttweatherapi.service.impl;

import static java.util.Comparator.comparing;
import com.leonovets.ttweatherapi.model.dto.AverageTemperatureCelsiusDto;
import com.leonovets.ttweatherapi.repository.entity.WeatherReport;
import com.leonovets.ttweatherapi.service.AverageTemperatureService;
import com.leonovets.ttweatherapi.service.crud.WeatherReportCrudService;
import com.leonovets.ttweatherapi.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * AverageTemperatureService implements {@link com.leonovets.ttweatherapi.service.AverageTemperatureService}.
 * Used to do needed calculations to get Average Temperatures Celsius by Dates
 * using {@link com.leonovets.ttweatherapi.service.crud.WeatherReportCrudService}.
 *
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 21:12
 */
@RequiredArgsConstructor
@Service
public class AverageTemperatureServiceImpl implements AverageTemperatureService {
    private final WeatherReportCrudService weatherReportCrudService;

    @Override
    public List<AverageTemperatureCelsiusDto> getAverageTemperaturesCelsiusForLocation(final Date from,
                                                                                       final Date to,
                                                                                       final String location) throws NotFoundException {
        final List<WeatherReport> temperatureCelsius = weatherReportCrudService.getWeatherReportsByPeriodAndLocation(from,
                to, location);
        final Map<Date, List<WeatherReport>> groups = groupWeatherReportsByDate(temperatureCelsius);
        return calculateAverageTemperature(groups);
    }

    /**
     * Grouping WeatherReports by Date.
     *
     * @param weatherReports to be grouped
     * @return grouped weather reports by dates
     */
    private Map<Date, List<WeatherReport>> groupWeatherReportsByDate(final List<WeatherReport> weatherReports) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return weatherReports.stream()
                .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(comparing(WeatherReport::getPostDate))),
                        ArrayList::new))
                .stream()
                .collect(Collectors.groupingBy(weatherReport -> {
                    try {
                        return simpleDateFormat.parse(simpleDateFormat.format(weatherReport.getPostDate()));
                    } catch (final ParseException exception) {
                        throw new RuntimeException(exception);
                    }
                }));
    }

    /**
     * Calculates Average Temperatures by dates and creates DTOs for them.
     *
     * @param groups contains grouped weather reports by dates
     * @return List of AveragesTemperatureCelsiusDto with needed information
     */
    private List<AverageTemperatureCelsiusDto> calculateAverageTemperature(final Map<Date, List<WeatherReport>> groups) {
        final List<AverageTemperatureCelsiusDto> result = new ArrayList<>();
        for (final Map.Entry<Date, List<WeatherReport>> group : groups.entrySet()) {
            result.add(new AverageTemperatureCelsiusDto(group.getValue().stream()
                    .mapToDouble(WeatherReport::getTemperatureCelsius)
                    .average()
                    .orElse(Double.NaN), group.getKey()));
        }
        return result;
    }
}
