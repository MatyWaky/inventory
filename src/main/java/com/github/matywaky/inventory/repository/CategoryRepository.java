package com.github.matywaky.inventory.repository;

import com.github.matywaky.inventory.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BasicJpaRepository<Category, Integer> {
}
