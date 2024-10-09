package com.github.matywaky.inventory.repository;

import com.github.matywaky.inventory.model.Country;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends BasicJpaRepository<Country, Integer> {
}
