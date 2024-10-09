package com.github.matywaky.inventory.repository;

import com.github.matywaky.inventory.model.Building;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends BasicJpaRepository<Building, Integer> {
}
