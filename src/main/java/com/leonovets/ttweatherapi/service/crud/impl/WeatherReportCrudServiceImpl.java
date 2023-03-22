package com.leonovets.ttweatherapi.service.crud.impl;

import com.leonovets.ttweatherapi.repository.WeatherReportRepository;
import com.leonovets.ttweatherapi.repository.entity.WeatherReport;
import com.leonovets.ttweatherapi.service.crud.ConditionCrudService;
import com.leonovets.ttweatherapi.service.crud.LocationCrudService;
import com.leonovets.ttweatherapi.service.crud.WeatherReportCrudService;
import com.leonovets.ttweatherapi.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * WeatherReport Service implements {@link com.leonovets.ttweatherapi.service.crud.WeatherReportCrudService}
 * uses {@link com.leonovets.ttweatherapi.repository.WeatherReportRepository} as Repository to execute CRUD operations.
 *
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 20:03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class WeatherReportCrudServiceImpl implements WeatherReportCrudService {
    private final LocationCrudService locationCrudService;
    private final ConditionCrudService conditionCrudService;
    private final WeatherReportRepository weatherReportRepository;

    @Override
    public WeatherReport save(final WeatherReport weatherReport) {
        log.info("Saving weather report");
        weatherReport.setLocation(locationCrudService.saveOrReturnExisted(weatherReport.getLocation()));
        weatherReport.setCondition(conditionCrudService.saveOrReturnExisted(weatherReport.getCondition()));
        return weatherReportRepository.save(weatherReport);
    }

    @Override
    public WeatherReport getLastWeatherReport(final String location) throws NotFoundException {
        final List<WeatherReport> weatherReports = weatherReportRepository.findNewestWeatherReportByLocation(location);
        if (weatherReports.size() == 0) {
            throw new NotFoundException(String.format("Weather report not found for '%s'", location));
        } else if (weatherReports.size() == 1) {
            return weatherReports.get(0);
        }
        return weatherReports.stream()
                .max(Comparator.comparing(WeatherReport::getId))
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<WeatherReport> getWeatherReportsByPeriodAndLocation(final Date from, final Date to, final String location)
            throws NotFoundException {
        final List<WeatherReport> reports = weatherReportRepository.getWeatherReportsByPeriodAndLocation(from, DateUtils.addMinutes(to,
                1439), location);
        if (reports.size() == 0) {
            throw new NotFoundException(String.format("Weather reports not found for '%s' and these dates. "
                    + "Cannot give average temperatures", location));
        }
        return reports;
    }
}
