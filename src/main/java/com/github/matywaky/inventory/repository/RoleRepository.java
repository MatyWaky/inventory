package com.github.matywaky.inventory.repository;

import com.github.matywaky.inventory.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
