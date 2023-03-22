package com.leonovets.ttweatherapi.service.crud;

import com.leonovets.ttweatherapi.repository.entity.Condition;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 23:14
 */
public interface ConditionCrudService {
    Condition saveOrReturnExisted(final Condition condition);

    Condition saveOrReturnExisted(final String name);
}
