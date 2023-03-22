package com.leonovets.ttweatherapi.repository;

import com.leonovets.ttweatherapi.repository.entity.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for Condition Entity {@link com.leonovets.ttweatherapi.repository.entity.Condition}
 * implements JpaRepository.
 *
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 23:12
 */
@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {

    /**
     * Finds Condition from the database.
     *
     * @param description is the Condition's field to be found by
     * @return Optional of Condition could contain Condition Entity from the Database
     */
    Optional<Condition> findByDescription(final String description);


}
