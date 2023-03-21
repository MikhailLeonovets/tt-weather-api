package com.leonovets.ttweatherapi.repository;

import com.leonovets.ttweatherapi.repository.entity.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 23:12
 */
@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {
    Optional<Condition> findByDescription(final String description);
}
