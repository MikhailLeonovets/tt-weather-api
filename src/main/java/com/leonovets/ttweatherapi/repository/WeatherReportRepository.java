package com.leonovets.ttweatherapi.repository;

import com.leonovets.ttweatherapi.repository.entity.WeatherReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Mikhail.Leonovets
 * @since 03/20/2023 - 22:48
 */
@Repository
public interface WeatherReportRepository extends JpaRepository<WeatherReport, Long> {

    @Query("SELECT w FROM WeatherReport w "
            + "WHERE w.postDate = (SELECT MAX(w.postDate) FROM WeatherReport w) "
            + "AND w.location.name = :location")
    List<WeatherReport> findNewestWeatherReportByLocation(final String location);

    @Query("SELECT w FROM WeatherReport w " +
            "WHERE w.location.name = :location " +
            "AND w.postDate BETWEEN :from AND :to")
    List<WeatherReport> getWeatherReportsByPeriodAndLocation(final Date from,
                                               final Date to,
                                               final String location);

}
