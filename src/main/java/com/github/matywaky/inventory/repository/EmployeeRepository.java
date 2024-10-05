package com.github.matywaky.inventory.repository;

import com.github.matywaky.inventory.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
