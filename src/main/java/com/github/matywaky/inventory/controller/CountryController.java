package com.github.matywaky.inventory.controller;

import com.github.matywaky.inventory.model.Country;
import com.github.matywaky.inventory.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/add/country")
    public String addCountryForm(Model model) {
        model.addAttribute("country", new Country());
        return "add-country";
    }

    @PostMapping("/add/country")
    public ResponseEntity<Map<String, String>> addCountry(@ModelAttribute Country country) {
        return countryService.saveAndReturnResponseEntity(country);
    }
}
