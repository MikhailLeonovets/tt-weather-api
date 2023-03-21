package com.leonovets.ttweatherapi.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Entity
public class WeatherReport extends Identity {
    private Integer temperatureCelsius;
    private Integer atmospherePressureHectopascal;
    private Integer airHumidity;
    private String weather;
    @ManyToOne(targetEntity = Location.class, fetch = FetchType.EAGER)
    @Column(name = "place_location_id")
    private Location location;
    private Date postDate;

}
