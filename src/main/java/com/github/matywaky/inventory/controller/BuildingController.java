package com.github.matywaky.inventory.controller;

import com.github.matywaky.inventory.model.Building;
import com.github.matywaky.inventory.service.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class BuildingController {

    private final BuildingService buildingService;

    @GetMapping("/add/building")
    public String addBuildingForm(Model model) {
        model.addAttribute("building", new Building());
        model.addAttribute("cities", buildingService.findAllCities());
        return "add-building";

    }

    @PostMapping("/add/building")
    public ResponseEntity<Map<String, String>> addBuilding(@ModelAttribute("building") Building building,
                                                           @RequestParam Integer cityId) {
        return buildingService.saveBuildingEntity(building, cityId);
    }
}
