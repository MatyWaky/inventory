package com.github.matywaky.inventory.repository;

import com.github.matywaky.inventory.model.City;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends BasicJpaRepository<City, Integer> {
}
