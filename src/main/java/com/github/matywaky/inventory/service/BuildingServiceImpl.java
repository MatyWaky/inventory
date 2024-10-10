package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.Building;
import com.github.matywaky.inventory.model.City;
import com.github.matywaky.inventory.model.Country;
import com.github.matywaky.inventory.repository.BuildingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuildingServiceImpl extends BasicJpaServiceImpl<Building, Integer> implements BuildingService {

    private final CityService cityService;

    public BuildingServiceImpl(BuildingRepository buildingRepository,
                               CityService cityService) {
        super(buildingRepository);
        this.cityService = cityService;
    }

    @Override
    public List<City> findAllCities() {
        return cityService.findAll();
    }

    @Override
    public ResponseEntity<Map<String, String>> saveBuildingEntity(Building building, Integer cityId) {
        return saveAndReturnEntityWithDependency(building, cityId, cityService::findById, Building::setCity);
    }
}
