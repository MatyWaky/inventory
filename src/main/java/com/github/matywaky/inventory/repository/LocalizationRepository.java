package com.github.matywaky.inventory.repository;

import com.github.matywaky.inventory.model.Localization;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizationRepository extends BasicJpaRepository<Localization, Integer> {
}
