package com.leonovets.ttweatherapi.repository.entity;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 15:29
 */
@NoArgsConstructor
@Entity
public class Location extends Identity {
    private String name;

}
