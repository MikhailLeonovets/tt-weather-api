package com.leonovets.ttweatherapi.service.crud.impl;

import com.leonovets.ttweatherapi.repository.LocationRepository;
import com.leonovets.ttweatherapi.repository.entity.Location;
import com.leonovets.ttweatherapi.service.crud.LocationCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 23:16
 */
@RequiredArgsConstructor
@Service
public class LocationCrudServiceImpl implements LocationCrudService {
    private final LocationRepository locationRepository;

    @Override
    public Location saveOrReturnExisted(final Location location) {
        return saveOrReturnExisted(location.getName());
    }

    @Override
    public Location saveOrReturnExisted(final String name) {
        return locationRepository.findByName(name).orElseGet(() -> locationRepository.save(new Location(name)));
    }
}
