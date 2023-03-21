package com.leonovets.ttweatherapi.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author Mikhail.Leonovets
 * @since 03/20/2023 - 22:48
 */
@Getter
@Setter
@NoArgsConstructor
@Table(name = "weather_report")
@Entity
public class WeatherReport extends Identity {
    private Integer temperatureCelsius;
    private Integer atmospherePressureHectopascal;
    private Integer airHumidity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "condition_id")
    private Condition condition;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "place_location_id")
    private Location location;
    private Date postDate;

}
