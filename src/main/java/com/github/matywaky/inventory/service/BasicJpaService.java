package com.github.matywaky.inventory.service;

import java.io.Serializable;
import java.util.List;

public interface BasicJpaService<T, ID extends Serializable> {
    T save(T entity);
    T findById(ID id);
    List<T> findAll();
    void delete(T entity);
    void deleteById(ID id);
    T update(T entity);
    T updateById(T entity, ID id);
}
