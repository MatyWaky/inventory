package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.Category;
import com.github.matywaky.inventory.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BasicJpaServiceImpl<Category, Integer> implements CategoryService {

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        super(categoryRepository);
    }
}
