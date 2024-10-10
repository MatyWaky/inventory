package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.Building;
import com.github.matywaky.inventory.model.Localization;
import com.github.matywaky.inventory.repository.LocalizationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LocalizationServiceImpl extends BasicJpaServiceImpl<Localization, Integer> implements LocalizationService {

    private final BuildingService buildingService;

    public LocalizationServiceImpl(LocalizationRepository repository,
                                   BuildingService buildingService) {
        super(repository);
        this.buildingService = buildingService;
    }

    @Override
    public List<Building> findAllBuildings() {
        return buildingService.findAll();
    }

    @Override
    public ResponseEntity<Map<String, String>> saveLocalizationEntity(Localization localization, Integer buildingId) {
        return saveAndReturnEntityWithDependency(
                localization,
                buildingId,
                buildingService::findById,
                Localization::setBuilding);
    }
}
