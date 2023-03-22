package com.leonovets.ttweatherapi.service.crud;

import com.leonovets.ttweatherapi.repository.entity.Location;

/**
 * Interface contains needed CRUD methods for Location Entity {@link com.leonovets.ttweatherapi.repository.entity.Location}.
 *
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 23:12
 */
public interface LocationCrudService {

    /**
     * Saving the entity Location if there is no location with required fields else returns existed.
     *
     * @param location to be saved
     * @return updated condition after saving with populated id field
     */
    Location saveOrReturnExisted(final Location location);

    /**
     * Saving the entity Location if there is no location with that name else returns existed with this name.
     *
     * @param name is the Location field to be stored
     * @return saved or existed Location
     */
    Location saveOrReturnExisted(final String name);
}
