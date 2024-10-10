package com.github.matywaky.inventory.service;

import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

public interface BasicJpaService<T, ID extends Serializable> {
    T save(T entity);
    T findById(ID id);
    List<T> findAll();
    void delete(T entity);
    void deleteById(ID id);
    T update(T entity);
    T updateById(T entity, ID id);
    ResponseEntity<Map<String, String>> saveAndReturnResponseEntity(T entity);
    <D> ResponseEntity<Map<String, String>> saveAndReturnEntityWithDependency(
            T entity,
            ID dependencyId,
            Function<ID, D> findDependencyFunction,
            BiConsumer<T, D> setDependencyFunction);
}
