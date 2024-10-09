package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.Localization;
import com.github.matywaky.inventory.repository.LocalizationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocalizationServiceImpl extends BasicJpaServiceImpl<Localization, Integer> implements LocalizationService {

    public LocalizationServiceImpl(LocalizationRepository repository) {
        super(repository);
    }
}
