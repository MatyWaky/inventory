package com.github.matywaky.inventory.controller;

import com.github.matywaky.inventory.service.StatusService;
import com.github.matywaky.inventory.model.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
@RequiredArgsConstructor
@Validated
public class StatusController {

    private final StatusService statusService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<Status>> getStatus() {
        return ResponseEntity.ok().body(statusService.getAllStatuses());
    }
}