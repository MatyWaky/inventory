package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.Employee;
import com.github.matywaky.inventory.model.Role;
import com.github.matywaky.inventory.model.User;

import java.util.List;

public interface UserService extends BasicJpaService<User, Integer> {

    String addUser(User user, String repeatedPassword, Integer roleId, Integer employeeId);
    List<Role> findAllRoles();
    List<Employee> findAllEmployees();
}
