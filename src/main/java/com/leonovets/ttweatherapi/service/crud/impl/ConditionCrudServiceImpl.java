package com.leonovets.ttweatherapi.service.crud.impl;

import com.leonovets.ttweatherapi.repository.ConditionRepository;
import com.leonovets.ttweatherapi.repository.entity.Condition;
import com.leonovets.ttweatherapi.service.crud.ConditionCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 23:15
 */
@RequiredArgsConstructor
@Service
public class ConditionCrudServiceImpl implements ConditionCrudService {
    private final ConditionRepository conditionRepository;

    @Override
    public Condition save(final Condition condition) {
        return save(condition.getDescription());
    }

    @Override
    public Condition save(final String description) {
        return conditionRepository.findByDescription(description).orElseGet(() -> conditionRepository.save(new Condition(description)));
    }
}
