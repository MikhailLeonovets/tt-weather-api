package com.leonovets.ttweatherapi.repository;

import com.leonovets.ttweatherapi.repository.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 23:11
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByName(final String name);
}
