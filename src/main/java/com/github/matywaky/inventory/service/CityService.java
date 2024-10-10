package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.City;
import com.github.matywaky.inventory.model.Country;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface CityService extends BasicJpaService<City, Integer> {
    List<Country> findAllCountries();
    ResponseEntity<Map<String, String>> saveAndReturnCityEntity(City entity, Integer countryId);
}
