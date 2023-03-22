package com.leonovets.ttweatherapi.service.crud.impl;

import com.leonovets.ttweatherapi.repository.LocationRepository;
import com.leonovets.ttweatherapi.repository.entity.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Mikhail.Leonovets
 * @since 03/22/2023 - 21:24
 */
@ExtendWith(MockitoExtension.class)
class LocationCrudServiceImplTest {
    @Mock
    private LocationRepository locationRepository;
    private LocationCrudServiceImpl locationCrudService;

    @BeforeEach
    void setUp() {
        locationCrudService = new LocationCrudServiceImpl(locationRepository);
    }

    @Test
    void testSaveOrReturnExistedByEntity() {
        // given
        final String locationName = "name1";
        final Location location = new Location(locationName);
        final Location expected = new Location(locationName);
        Mockito.doReturn(location).when(locationRepository).save(Mockito.any());

        // when
        final Location actual = locationCrudService.saveOrReturnExisted(location);

        // then
        Assertions.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    void testSaveOrReturnExistedByName() {
        // given
        final String locationName = "name1";
        final Location location = new Location(locationName);
        final Location expected = new Location(locationName);
        Mockito.doReturn(location).when(locationRepository).save(Mockito.any());

        // when
        final Location actual = locationCrudService.saveOrReturnExisted(locationName);

        // then
        Assertions.assertEquals(expected.getName(), actual.getName());
    }
}