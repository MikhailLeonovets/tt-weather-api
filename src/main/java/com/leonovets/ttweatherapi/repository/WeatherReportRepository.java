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

    @Query("SELECT w.temperatureCelsius FROM WeatherReport w WHERE w.date BETWEEN :from AND :to")
    List<Integer> getTemperatureByPeriod(final Date from,
                                         final Date to);

}
