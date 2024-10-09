package com.github.matywaky.inventory.repository;

import com.github.matywaky.inventory.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BasicJpaRepository<User, Integer> {
    User findByEmail(String email);
}
