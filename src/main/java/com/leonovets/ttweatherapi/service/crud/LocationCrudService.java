package com.leonovets.ttweatherapi.service.crud;

import com.leonovets.ttweatherapi.repository.entity.Location;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 23:12
 */
public interface LocationCrudService {
    Location saveOrReturnExisted(final Location location);

    Location saveOrReturnExisted(final String name);
}
