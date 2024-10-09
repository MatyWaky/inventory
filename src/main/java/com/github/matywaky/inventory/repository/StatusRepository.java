package com.github.matywaky.inventory.repository;

import com.github.matywaky.inventory.model.Status;
import com.github.matywaky.inventory.service.BasicJpaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends BasicJpaRepository<Status, Integer> {
}
