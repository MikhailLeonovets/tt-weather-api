package com.leonovets.ttweatherapi.service.crud;

import com.leonovets.ttweatherapi.repository.entity.Condition;

/**
 * Service to be used as a CRUD service for Condition Entity {@link com.leonovets.ttweatherapi.repository.entity.Condition}.
 *
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 23:14
 */
public interface ConditionCrudService {
    /**
     * Saving the entity Condition if there is no condition with required fields else returns existed.
     *
     * @param condition to be saved
     * @return updated condition after saving with populated id field
     */
    Condition saveOrReturnExisted(final Condition condition);

    /**
     * Saving the entity Condition if there is no condition with that description else returns existed with this description.
     *
     * @param description field to be saved in the Condition
     * @return saved or existed Condition
     */
    Condition saveOrReturnExisted(final String description);
}
