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

    public Condition(final String description) {
        this.description = description;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        final Condition condition = (Condition) o;
        return getId() != null && Objects.equals(getId(), condition.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
