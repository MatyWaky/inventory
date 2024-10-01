package com.github.matywaky.inventory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatusService {

    private final StatusRepository statusRepository;

    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }
}
