package com.leonovets.ttweatherapi.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.leonovets.ttweatherapi.model.json_serializer.CustomDateSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 21:06
 */
@Getter
@Setter
@NoArgsConstructor
public class AverageTemperatureCelsiusDto {
    private Double averageTemperatureCelsius;
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date date;

    public AverageTemperatureCelsiusDto(final Double averageTemperatureCelsius, final Date date) {
        this.averageTemperatureCelsius = Math.round(averageTemperatureCelsius * 10) / 10D;
        this.date = date;
    }
}

