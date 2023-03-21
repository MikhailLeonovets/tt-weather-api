package com.leonovets.ttweatherapi.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leonovets.ttweatherapi.repository.entity.Condition;
import com.leonovets.ttweatherapi.repository.entity.Location;
import com.leonovets.ttweatherapi.repository.entity.WeatherReport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 19:10
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherReportDto {
    private Float temperatureCelsius;
    private Float windMetersPerHour;
    private Float atmospherePressureHectopascal;
    private Integer airHumidity;
    private String condition;
    private Date postDate;
    private String location;

    @JsonIgnore
    public Date getPostDate() {
        return this.getPostDate();
    }


    public WeatherReport buildWeatherReportFromDto() {
        final WeatherReport weatherReport = new WeatherReport();
        weatherReport.setTemperatureCelsius(temperatureCelsius);
        weatherReport.setWindMetersPerHour(windMetersPerHour);
        weatherReport.setAtmospherePressureHectopascal(atmospherePressureHectopascal);
        weatherReport.setAirHumidity(airHumidity);
        weatherReport.setCondition(new Condition(condition));
        weatherReport.setLocation(new Location(location));
        weatherReport.setPostDate(postDate);
        return weatherReport;
    }

    public static WeatherReportDto createFromEntity(final WeatherReport weatherReport) {
        final WeatherReportDto weatherResponseDto = new WeatherReportDto();
        weatherResponseDto.setTemperatureCelsius(weatherReport.getTemperatureCelsius());
        weatherResponseDto.setWindMetersPerHour(weatherReport.getWindMetersPerHour());
        weatherResponseDto.setAtmospherePressureHectopascal(weatherReport.getAtmospherePressureHectopascal());
        weatherResponseDto.setAirHumidity(weatherReport.getAirHumidity());
        weatherResponseDto.setCondition(weatherReport.getCondition().getDescription());
        weatherResponseDto.setPostDate(weatherReport.getPostDate());
        weatherResponseDto.setLocation(weatherReport.getLocation().getName());
        return weatherResponseDto;
    }

}
