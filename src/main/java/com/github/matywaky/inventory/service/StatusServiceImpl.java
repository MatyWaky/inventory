package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.Status;
import com.github.matywaky.inventory.repository.StatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StatusServiceImpl extends BasicJpaServiceImpl<Status, Integer> implements StatusService {

    public StatusServiceImpl(StatusRepository statusRepository) {
        super(statusRepository);
    }
}
