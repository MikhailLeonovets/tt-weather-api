package com.leonovets.ttweatherapi.repository;

import com.leonovets.ttweatherapi.repository.entity.WeatherReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Repository for Location Entity {@link com.leonovets.ttweatherapi.repository.entity.WeatherReport}
 * implements JpaRepository.
 *
 * @author Mikhail.Leonovets
 * @since 03/20/2023 - 22:48
 */
@Repository
public interface WeatherReportRepository extends JpaRepository<WeatherReport, Long> {

    /**
     * Finds the newest data in the weather_report database table.
     *
     * @param location is from weather report you want
     * @return WeatherReport entity with the information from the database
     */
    @Query("SELECT w FROM WeatherReport w "
            + "WHERE w.postDate = (SELECT MAX(w.postDate) FROM WeatherReport w) "
            + "AND w.location.name = :location")
    List<WeatherReport> findNewestWeatherReportByLocation(final String location);

    /**
     * Finds List of WeatherReports in that period and that location.
     *
     * @param from start date of the period
     * @param to end date of the period
     * @param location is from weather report you want
     * @return WeatherReport which contains needed Location and postDate in the period from the database
     */
    @Query("SELECT w FROM WeatherReport w "
            + "WHERE w.location.name = :location "
            + "AND w.postDate BETWEEN :from AND :to")
    List<WeatherReport> getWeatherReportsByPeriodAndLocation(final Date from,
                                                             final Date to,
                                                             final String location);

}
