package com.leonovets.ttweatherapi.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * Entity to be stored in the Database and used as field for WeatherReport
 * {@link com.leonovets.ttweatherapi.repository.entity.WeatherReport}.
 *
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 15:29
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "place_location")
@Entity
public class Location extends Identity {
    private String name;

    /**
     * Constructor exclude id.
     *
     * @param name is the Location's field
     */
    public Location(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || Hibernate.getClass(this) != Hibernate.getClass(object)) return false;
        final Location location = (Location) object;
        return getId() != null && Objects.equals(getId(), location.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
