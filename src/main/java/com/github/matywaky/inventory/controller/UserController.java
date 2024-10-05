package com.github.matywaky.inventory.controller;

import com.github.matywaky.inventory.model.Role;
import com.github.matywaky.inventory.model.User;
import com.github.matywaky.inventory.service.RoleService;
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
    private final RoleService roleService;

    @GetMapping("/addUser")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRoles());
        return "add-user";
    }

    @PostMapping("/addUser")
    public ResponseEntity<Map<String, String>> addUser(
            @ModelAttribute User user,
            @RequestParam String repeatPassword,
            @RequestParam Integer roleId) {
        Map<String, String> response = new HashMap<>();

        String error = userService.dataCommunicate(user.getEmail(), user.getPassword(), repeatPassword);
        if (error != null) {
            response.put("status", "error");
            response.put("message", error);
            return ResponseEntity.badRequest().body(response);
        }

        Role role = roleService.getRoleById(roleId);
        if (role == null) {
            response.put("status", "error");
            response.put("message", "Role not found");
            return ResponseEntity.badRequest().body(response);
        }
        user.setRole(role);

        //userService.saveUser(user);
        response.put("status", "success");
        response.put("message", "User added successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }
}
