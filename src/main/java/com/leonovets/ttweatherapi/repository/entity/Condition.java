package com.leonovets.ttweatherapi.repository.entity;

import jakarta.persistence.Entity;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 17:25
 */
@Entity
public class Condition extends Identity {
    private String description;
}
