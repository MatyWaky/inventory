package com.github.matywaky.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"", "/"})
    public String home(Model model) {
        model.addAttribute("title", "InventoryApp");
        model.addAttribute("pageDescription", "Inventory application written in Spring Boot");
        return "index";
    }
}
