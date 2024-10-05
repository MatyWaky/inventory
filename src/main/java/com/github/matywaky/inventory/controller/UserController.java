package com.github.matywaky.inventory.controller;

import com.github.matywaky.inventory.model.Role;
import com.github.matywaky.inventory.model.User;
import com.github.matywaky.inventory.repository.RoleRepository;
import com.github.matywaky.inventory.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RoleRepository roleRepository;

    @GetMapping("/addUser")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", userService.getAllRoles());
        return "add-user";
    }

    @PostMapping("/addUser")
    public ResponseEntity<Map<String, String>> addUser(
            @ModelAttribute User user,
            @RequestParam String repeatPassword,
            @RequestParam Integer roleId) {
        Map<String, String> response = new HashMap<>();

        if (!user.getPassword().equals(repeatPassword)) {
            response.put("status", "error");
            response.put("message", "Passwords do not match");
            return ResponseEntity.badRequest().body(response);
        }

        Optional<Role> role = roleRepository.findById(roleId);
        if (role.isEmpty()) {
            response.put("status", "error");
            response.put("message", "Role not found");
            return ResponseEntity.badRequest().body(response);
        }
        user.setRole(role.orElse(null));

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
