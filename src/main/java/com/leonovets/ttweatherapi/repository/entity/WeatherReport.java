package com.leonovets.ttweatherapi.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Date;
import java.util.Objects;

/**
 * @author Mikhail.Leonovets
 * @since 03/20/2023 - 22:48
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "weather_report")
@Entity
public class WeatherReport extends Identity {
    private Float temperatureCelsius;
    private Float windMetersPerHour;
    private Float atmospherePressureHectopascal;
    private Integer airHumidity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "condition_id")
    private Condition condition;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "place_location_id")
    private Location location;
    private Date postDate;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        final WeatherReport that = (WeatherReport) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
