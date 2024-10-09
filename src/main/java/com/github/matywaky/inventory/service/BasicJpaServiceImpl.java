package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.repository.BasicJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

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
}
