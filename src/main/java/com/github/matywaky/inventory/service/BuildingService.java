package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.Building;
import com.github.matywaky.inventory.model.City;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface BuildingService extends BasicJpaService<Building, Integer> {
    List<City> findAllCities();
    ResponseEntity<Map<String, String>> saveBuildingEntity(Building building, Integer cityId);
}
