package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
