package com.github.matywaky.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BasicJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
