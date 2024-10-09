package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.Role;
import com.github.matywaky.inventory.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BasicJpaServiceImpl<Role, Integer> implements RoleService {

    public RoleServiceImpl(RoleRepository roleRepository) {
        super(roleRepository);
    }
}
