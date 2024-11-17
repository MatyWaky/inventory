package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ProductService extends BasicJpaService<Product, Integer> {
    List<Category> findAllCategories();
    List<Localization> findAllLocalizations();
    List<Employee> findAllEmployees();
    List<Status> findAllStatuses();
    String addProduct(Product product,
                      Integer categoryId,
                      Integer localizationId,
                      Integer employeeId,
                      Integer statusId);
}
