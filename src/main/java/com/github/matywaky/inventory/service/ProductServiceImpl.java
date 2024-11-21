package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.*;
import com.github.matywaky.inventory.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ProductServiceImpl extends BasicJpaServiceImpl<Product, Integer> implements ProductService {

    private final CategoryService categoryService;
    private final LocalizationService localizationService;
    private final EmployeeService employeeService;
    private final StatusService statusService;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryService categoryService,
                              LocalizationService localizationService,
                              EmployeeService employeeService,
                              StatusService statusService) {
        super(productRepository);
        this.categoryService = categoryService;
        this.localizationService = localizationService;
        this.employeeService = employeeService;
        this.statusService = statusService;
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryService.findAll();
    }

    @Override
    public List<Localization> findAllLocalizations() {
        return localizationService.findAll();
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeService.findAll();
    }

    @Override
    public List<Status> findAllStatuses() {
        return statusService.findAll();
    }

    @Override
    public String addProduct(Product product,
                             Integer categoryId,
                             Integer localizationId,
                             Integer employeeId,
                             Integer statusId) {
        Category category = categoryService.findById(categoryId);
        if (category == null) {
            return "Category does not exist";
        }
        product.setCategory(category);

        Localization localization = localizationService.findById(localizationId);
        if (localization == null) {
            return "Localization does not exist";
        }
        product.setLocalization(localization);

        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            return "Employee does not exist";
        }
        product.setEmployee(employee);

        Status status = statusService.findById(statusId);
        if (status == null) {
            return "Status does not exist";
        }
        product.setStatus(status);

        product.setAddedDate(new Date());

        save(product);
        return null;
    }
}
