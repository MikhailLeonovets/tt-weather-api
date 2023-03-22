package com.leonovets.ttweatherapi.repository;

import com.leonovets.ttweatherapi.repository.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for Location Entity {@link com.leonovets.ttweatherapi.repository.entity.Location}
 * implements JpaRepository.
 *
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 23:11
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    /**
     * Finds Location Entity by its name in the SQL database.
     *
     * @param name is the name of a Location Entity
     * @return Optional of Location could contain the Entity
     */
    Optional<Location> findByName(final String name);

}
