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
 * @since 03/21/2023 - 17:25
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "condition")
@Entity
public class Condition extends Identity {
    private String description;

    /**
     * Constructor exclude id.
     *
     * @param description is the Condition's filed to be populated
     */
    public Condition(final String description) {
        this.description = description;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || Hibernate.getClass(this) != Hibernate.getClass(object)) return false;
        final Condition condition = (Condition) object;
        return getId() != null && Objects.equals(getId(), condition.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
