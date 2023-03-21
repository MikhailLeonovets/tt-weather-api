package com.leonovets.ttweatherapi.service;

import com.leonovets.ttweatherapi.repository.entity.Condition;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 23:14
 */
public interface ConditionCrudService {
    Condition save(final Condition condition);

    Condition save(final String name);
}
