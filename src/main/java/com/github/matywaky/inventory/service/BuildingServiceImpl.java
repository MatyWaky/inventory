package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.Building;
import com.github.matywaky.inventory.repository.BuildingRepository;
import org.springframework.stereotype.Service;

@Service
public class BuildingServiceImpl extends BasicJpaServiceImpl<Building, Integer> implements BuildingService {

    public BuildingServiceImpl(BuildingRepository buildingRepository) {
        super(buildingRepository);
    }
}
