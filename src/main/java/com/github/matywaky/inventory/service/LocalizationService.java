package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.Building;
import com.github.matywaky.inventory.model.Localization;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface LocalizationService extends BasicJpaService<Localization, Integer> {
    List<Building> findAllBuildings();
    ResponseEntity<Map<String, String>> saveLocalizationEntity(Localization localization, Integer buildingId);
}
