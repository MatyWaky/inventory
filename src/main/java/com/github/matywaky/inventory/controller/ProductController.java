package com.github.matywaky.inventory.controller;

import com.github.matywaky.inventory.model.Product;
import com.github.matywaky.inventory.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/add/product")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", productService.findAllCategories());
        model.addAttribute("localizations", productService.findAllLocalizations());
        model.addAttribute("employees", productService.findAllEmployees());
        model.addAttribute("statuses", productService.findAllStatuses());
        return "add-product";
    }

    @PostMapping("/add/product")
    public ResponseEntity<Map<String, String>> addProduct(@ModelAttribute Product product,
                                                          @RequestParam Integer categoryId,
                                                          @RequestParam Integer localizationId,
                                                          @RequestParam Integer employeeId,
                                                          @RequestParam Integer statusId) {
        Map<String, String> response = new HashMap<>();

        String error = productService.addProduct(product, categoryId, localizationId, employeeId, statusId);
        if (error != null) {
            response.put("status", "error");
            response.put("message", error);
            return ResponseEntity.badRequest().body(response);
        } else {
            response.put("status", "success");
            response.put("message", "Product added successfully");
        }

        return ResponseEntity.ok(response);
    }
}
