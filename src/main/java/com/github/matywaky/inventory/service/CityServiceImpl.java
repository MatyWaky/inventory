package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.City;
import com.github.matywaky.inventory.model.Country;
import com.github.matywaky.inventory.repository.CityRepository;
import com.github.matywaky.inventory.repository.CountryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CityServiceImpl extends BasicJpaServiceImpl<City, Integer> implements CityService {

    private final CountryService countryService;

    public CityServiceImpl(CityRepository cityRepository,
                           CountryService countryService) {
        super(cityRepository);
        this.countryService = countryService;
    }

    @Override
    public List<Country> findAllCountries() {
        return countryService.findAll();
    }

    @Override
    public ResponseEntity<Map<String, String>> saveCityEntity(City city, Integer countryId) {
        return saveAndReturnEntityWithDependency(city, countryId, countryService::findById, City::setCountry);
    }
}
