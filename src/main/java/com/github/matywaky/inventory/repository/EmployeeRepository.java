package com.github.matywaky.inventory.repository;

import com.github.matywaky.inventory.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends BasicJpaRepository<Employee, Integer> {
}
