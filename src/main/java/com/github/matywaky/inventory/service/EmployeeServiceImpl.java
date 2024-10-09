package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.Employee;
import com.github.matywaky.inventory.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends BasicJpaServiceImpl<Employee, Integer> implements EmployeeService {

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super(employeeRepository);
    }
}
