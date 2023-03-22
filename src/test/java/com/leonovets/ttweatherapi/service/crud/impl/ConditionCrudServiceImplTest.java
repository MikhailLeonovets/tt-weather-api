package com.leonovets.ttweatherapi.service.crud.impl;

import com.leonovets.ttweatherapi.repository.ConditionRepository;
import com.leonovets.ttweatherapi.repository.entity.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Mikhail.Leonovets
 * @since 03/22/2023 - 21:09
 */
@ExtendWith(MockitoExtension.class)
class ConditionCrudServiceImplTest {
    @Mock
    private ConditionRepository conditionRepository;
    private ConditionCrudServiceImpl conditionCrudService;

    @BeforeEach
    void setUp() {
        conditionCrudService = new ConditionCrudServiceImpl(conditionRepository);
    }

    @Test
    void testSaveOrReturnExistedByEntity() {
        // given
        final String description = "desc1";
        final Condition condition = new Condition();
        final Condition expected = new Condition();
        condition.setDescription(description);
        expected.setDescription(description);
        Mockito.doReturn(condition).when(conditionRepository).save(Mockito.any());

        // when
        final Condition actual = conditionCrudService.saveOrReturnExisted(condition);

        // then
        Assertions.assertEquals(expected.getDescription(), actual.getDescription());
    }

    @Test
    void testSaveOrReturnExistedByDescription() {
        // given
        final String description = "desc1";
        final Condition condition = new Condition();
        final Condition expected = new Condition();
        condition.setDescription(description);
        expected.setDescription(description);
        Mockito.doReturn(condition).when(conditionRepository).save(Mockito.any());

        // when
        final Condition actual = conditionCrudService.saveOrReturnExisted(condition.getDescription());

        // then
        Assertions.assertEquals(expected.getDescription(), actual.getDescription());
    }
}