package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.Country;
import com.github.matywaky.inventory.repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends BasicJpaServiceImpl<Country, Integer> implements CountryService {

    public CountryServiceImpl(CountryRepository countryRepository) {
        super(countryRepository);
    }
}
