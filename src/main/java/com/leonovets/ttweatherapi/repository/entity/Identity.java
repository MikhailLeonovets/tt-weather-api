package com.leonovets.ttweatherapi.repository.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 15:28
 */
@Getter
@Setter
@MappedSuperclass
public class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
