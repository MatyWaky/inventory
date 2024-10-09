package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.City;
import com.github.matywaky.inventory.repository.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends BasicJpaServiceImpl<City, Integer> implements CityService {

    public CityServiceImpl(CityRepository cityRepository) {
        super(cityRepository);
    }
}
