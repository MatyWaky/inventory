package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.Product;
import com.github.matywaky.inventory.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends BasicJpaServiceImpl<Product, Integer> implements ProductService {

    public ProductServiceImpl(ProductRepository productRepository) {
        super(productRepository);
    }
}
