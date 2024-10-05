package com.github.matywaky.inventory.repository;

import com.github.matywaky.inventory.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
