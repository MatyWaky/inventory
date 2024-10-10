package com.github.matywaky.inventory.controller;

import com.github.matywaky.inventory.model.City;
import com.github.matywaky.inventory.service.CityService;
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
public class CityController {

    private final CityService cityService;

    @GetMapping("/add/city")
    public String addCityForm(Model model) {
        model.addAttribute("city", new City());
        model.addAttribute("countries", cityService.findAllCountries());

        return "add-city";
    }

    @PostMapping("/add/city")
    public ResponseEntity<Map<String, String>> addCity(@ModelAttribute City city,
                                                       @RequestParam Integer countryId) {
        return cityService.saveCityEntity(city, countryId);
    }
}
