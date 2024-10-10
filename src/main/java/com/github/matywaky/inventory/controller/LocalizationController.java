package com.github.matywaky.inventory.controller;

import com.github.matywaky.inventory.model.Localization;
import com.github.matywaky.inventory.service.LocalizationService;
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
public class LocalizationController {

    private final LocalizationService localizationService;

    @GetMapping("/add/localization")
    public String addLocalizationForm(Model model) {
        model.addAttribute("localization", new Localization());
        model.addAttribute("buildings", localizationService.findAllBuildings());
        return "add-localization";
    }

    @PostMapping("/add/localization")
    public ResponseEntity<Map<String, String>> addLocalization(@ModelAttribute("localization") Localization localization,
                                                               @RequestParam Integer buildingId) {
        return localizationService.saveLocalizationEntity(localization, buildingId);
    }
}
