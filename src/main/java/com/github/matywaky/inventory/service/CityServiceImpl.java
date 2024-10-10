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
    public ResponseEntity<Map<String, String>> saveAndReturnCityEntity(City city, Integer countryId) {
        Country country = countryService.findById(countryId);
        if (country == null) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Country not found");
            error.put("status", "error");
            return ResponseEntity.badRequest().body(error);
        }

        city.setCountry(country);
        return saveAndReturnResponseEntity(city);
    }
}
