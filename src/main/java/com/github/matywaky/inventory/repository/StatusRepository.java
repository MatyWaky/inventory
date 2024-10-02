package com.github.matywaky.inventory;

import com.github.matywaky.inventory.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
