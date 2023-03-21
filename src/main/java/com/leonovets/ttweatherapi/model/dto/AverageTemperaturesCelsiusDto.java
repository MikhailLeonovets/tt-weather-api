package com.leonovets.ttweatherapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 21:06
 */
@Getter
@Setter
@AllArgsConstructor
public class AverageTemperaturesCelsiusDto {
    private Double averageTemperatureCelsius;
    private Date date;

}
