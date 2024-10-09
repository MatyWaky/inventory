package com.github.matywaky.inventory.repository;

import com.github.matywaky.inventory.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BasicJpaRepository<Role, Integer> {
}
