package com.leonovets.ttweatherapi.service.crud.impl;

import com.leonovets.ttweatherapi.repository.WeatherReportRepository;
import com.leonovets.ttweatherapi.repository.entity.Condition;
import com.leonovets.ttweatherapi.repository.entity.Location;
import com.leonovets.ttweatherapi.repository.entity.WeatherReport;
import com.leonovets.ttweatherapi.service.crud.ConditionCrudService;
import com.leonovets.ttweatherapi.service.crud.LocationCrudService;
import com.leonovets.ttweatherapi.service.exception.NotFoundException;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Mikhail.Leonovets
 * @since 03/22/2023 - 21:28
 */
@ExtendWith(MockitoExtension.class)
class WeatherReportCrudServiceImplTest {
    @Mock
    private LocationCrudService locationCrudService;
    @Mock
    private ConditionCrudService conditionCrudService;
    @Mock
    private WeatherReportRepository weatherReportRepository;
    private WeatherReportCrudServiceImpl weatherReportCrudService;

    @BeforeEach
    void setUp() {
        weatherReportCrudService = new WeatherReportCrudServiceImpl(locationCrudService, conditionCrudService, weatherReportRepository);
    }

    @Test
    void testSave() {
        // given
        final String description = "desc1";
        final String locationName = "loc1";
        final Float temperature = 8.1F;
        final Date postDate = new Date();
        final WeatherReport weatherReport = new WeatherReport();
        weatherReport.setCondition(new Condition(description));
        weatherReport.setLocation(new Location(locationName));
        weatherReport.setPostDate(postDate);
        weatherReport.setTemperatureCelsius(temperature);
        final WeatherReport expected = new WeatherReport();
        expected.setCondition(new Condition(description));
        expected.setLocation(new Location(locationName));
        expected.setPostDate(postDate);
        expected.setTemperatureCelsius(temperature);

        Mockito.doReturn(new Condition(description)).when(conditionCrudService).saveOrReturnExisted(weatherReport.getCondition());
        Mockito.doReturn(new Location(locationName)).when(locationCrudService).saveOrReturnExisted(weatherReport.getLocation());
        Mockito.doReturn(weatherReport).when(weatherReportRepository).save(Mockito.any());

        // when
        final WeatherReport actual = weatherReportCrudService.save(weatherReport);

        // then
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testGetLastWeatherReportThrowsException() {
        // given
        final String location = "location1";
        Mockito.doReturn(new ArrayList<>()).when(weatherReportRepository).findNewestWeatherReportByLocation(location);

        // when
        // then
        Assertions.assertThrows(NotFoundException.class,
                () -> weatherReportCrudService.getLastWeatherReport(location));

    }

    @Test
    void testGetLastWeatherReportWithSingObjInList() throws NotFoundException {
        // given
        final String location = "loc1";
        final WeatherReport weatherReport = new WeatherReport();
        weatherReport.setLocation(new Location(location));
        weatherReport.setCondition(new Condition());
        weatherReport.setAirHumidity(84);
        weatherReport.setPostDate(new Date());
        final WeatherReport expected = new WeatherReport();
        expected.setLocation(new Location(location));
        expected.setCondition(new Condition());
        expected.setAirHumidity(84);
        expected.setPostDate(new Date());
        Mockito.doReturn(new ArrayList<>(List.of(weatherReport))).when(weatherReportRepository).findNewestWeatherReportByLocation(location);

        // when
        final WeatherReport actual = weatherReportCrudService.getLastWeatherReport(location);

        // then
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testGetLastWeatherReportWithMultiObjInList() throws NotFoundException {
        // given
        final String location = "loc1";
        final Date date = new Date(100400);
        final Long id = 5L; // should be > 1
        final WeatherReport expected = new WeatherReport();
        expected.setId(id);
        expected.setLocation(new Location(location));
        expected.setCondition(new Condition());
        expected.setPostDate(date);
        Mockito.doReturn(multipleWeatherReports(date, id))
                .when(weatherReportRepository)
                .findNewestWeatherReportByLocation(location);

        // when
        final WeatherReport actual = weatherReportCrudService.getLastWeatherReport(location);

        // then
        Assertions.assertEquals(expected.toString(), actual.toString());
    }


    @Test
    void testGetWeatherReportsByPeriodAndLocationThrowsNotFoundException() {
        // given
        final String location = "loc1";
        final Date from = new Date(1000);
        final Date to = new Date(1100);
        Mockito.doReturn(new ArrayList<>()).when(weatherReportRepository).getWeatherReportsByPeriodAndLocation(from,
                DateUtils.addMinutes(to, 1439), location);

        // when
        // then
        Assertions.assertThrows(NotFoundException.class,
                () -> weatherReportCrudService.getWeatherReportsByPeriodAndLocation(from, to, location));
    }

    @Test
    void testGetWeatherReportsByPeriodAndLocation() throws NotFoundException {
        // given
        final Long id = 1L;
        final String location = "loc1";
        final Date from = new Date(1000);
        final Date to = new Date(1100);
        final List<WeatherReport> reports = multipleWeatherReports(from, id);
        final List<WeatherReport> expected = new ArrayList<>(reports);
        Mockito.doReturn(reports).when(weatherReportRepository).getWeatherReportsByPeriodAndLocation(from,
                DateUtils.addMinutes(to, 1439), location);

        // when
        final List<WeatherReport> actual = weatherReportCrudService.getWeatherReportsByPeriodAndLocation(from, to, location);

        // then
        Assertions.assertIterableEquals(expected, actual);
    }

    private List<WeatherReport> multipleWeatherReports(final Date date, final Long id) {
        final Date date1 = new Date(date.getTime() - 100);
        final WeatherReport weatherReport1 = new WeatherReport();
        weatherReport1.setId(id + 1L);
        weatherReport1.setLocation(new Location("loc1"));
        weatherReport1.setCondition(new Condition());
        weatherReport1.setPostDate(date1);
        final WeatherReport weatherReport2 = new WeatherReport();
        weatherReport2.setId(id - 1L);
        weatherReport2.setLocation(new Location("loc1"));
        weatherReport2.setCondition(new Condition());
        weatherReport2.setPostDate(date);
        final WeatherReport weatherReport3 = new WeatherReport();
        weatherReport3.setId(id);
        weatherReport3.setLocation(new Location("loc1"));
        weatherReport3.setCondition(new Condition());
        weatherReport3.setPostDate(date);
        return List.of(weatherReport1, weatherReport2, weatherReport3);
    }

}