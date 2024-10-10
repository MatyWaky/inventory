package com.github.matywaky.inventory.controller;

import com.github.matywaky.inventory.model.Category;
import com.github.matywaky.inventory.service.CategoryService;
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
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/add/category")
    public String addCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "add-category";
    }

    @PostMapping("/add/category")
    public ResponseEntity<Map<String, String>> addCategory(@ModelAttribute Category category) {
        return categoryService.saveAndReturnResponseEntity(category);
    }
}
