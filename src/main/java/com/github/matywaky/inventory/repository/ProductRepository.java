package com.github.matywaky.inventory.repository;

import com.github.matywaky.inventory.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BasicJpaRepository<Product, Integer> {
}
