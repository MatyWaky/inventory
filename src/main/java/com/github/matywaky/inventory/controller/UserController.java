package com.github.matywaky.inventory.controller;

import com.github.matywaky.inventory.model.User;
import com.github.matywaky.inventory.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/add/user")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", userService.findAllRoles());
        model.addAttribute("employees", userService.findAllEmployees());
        return "add-user";
    }

    @PostMapping("/add/user")
    public ResponseEntity<Map<String, String>> addUser (
            @ModelAttribute User user,
            @RequestParam String repeatPassword,
            @RequestParam Integer roleId,
            @RequestParam Integer employeeId) {
        Map<String, String> response = new HashMap<>();

        String error = userService.addUser(user, repeatPassword, roleId, employeeId);
        if (error != null) {
            response.put("status", "error");
            response.put("message", error);
            return ResponseEntity.badRequest().body(response);
        } else {
            response.put("status", "success");
            response.put("message", "User added successfully");
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.findAll());
    }
}
