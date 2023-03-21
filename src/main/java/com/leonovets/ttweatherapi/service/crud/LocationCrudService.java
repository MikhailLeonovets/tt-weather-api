package com.leonovets.ttweatherapi.service.crud;

import com.leonovets.ttweatherapi.repository.entity.Location;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 23:12
 */
public interface LocationCrudService {
    Location save(final Location location);

    Location save(final String name);
}
