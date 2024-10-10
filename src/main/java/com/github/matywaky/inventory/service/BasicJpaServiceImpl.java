package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.repository.BasicJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public abstract class BasicJpaServiceImpl<T, ID extends Serializable> implements BasicJpaService<T, ID> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    protected final BasicJpaRepository<T, ID> basicJpaRepository;

    @Override
    public T save(T entity) {
        return basicJpaRepository.save(entity);
    }

    @Override
    public T findById(ID id) {
        return basicJpaRepository.findById(id).orElse(null);
    }

    @Override
    public List<T> findAll() {
        return basicJpaRepository.findAll();
    }

    @Override
    public void delete(T entity) {
        basicJpaRepository.delete(entity);
    }

    @Override
    public void deleteById(ID id) {
        basicJpaRepository.deleteById(id);
    }

    @Override
    public T update(T entity) {
        return basicJpaRepository.save(entity);
    }

    @Override
    public T updateById(T entity, ID id) {
        if (basicJpaRepository.existsById(id)) {
            return basicJpaRepository.save(entity);
        }
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> saveAndReturnResponseEntity(T entity) {
        Map<String, String> response = new HashMap<>();

        try {
            save(entity);
            response.put("status", "success");
            response.put("message", "Added successfully");
            return ResponseEntity.ok(response);
        } catch (DataIntegrityViolationException e) {
            response.put("status", "error");
            response.put("message", "Already exists.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response); // 409 Conflict
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "An unexpected error occurred.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // 500 Internal Server Error
        }
    }

    @Override
    public <D> ResponseEntity<Map<String, String>> saveAndReturnEntityWithDependency(
            T entity,
            ID dependencyId,
            Function<ID, D> findDependencyFunction,
            BiConsumer<T, D> setDependencyFunction) {

        D dependency = findDependencyFunction.apply(dependencyId);
        Map<String, String> response = new HashMap<>();

        if (dependency == null) {
            response.put("status", "error");
            response.put("message", "Dependency not found.");
            return ResponseEntity.badRequest().body(response);
        }

        setDependencyFunction.accept(entity, dependency);

        try {
            save(entity);
            response.put("status", "success");
            response.put("message", "Added successfully.");
            return ResponseEntity.ok(response);
        } catch (DataIntegrityViolationException e) {
            response.put("status", "error");
            response.put("message", "Entity already exists.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "An unexpected error occurred.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
