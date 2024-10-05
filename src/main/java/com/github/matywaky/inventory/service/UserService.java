package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.Role;
import com.github.matywaky.inventory.model.User;
import com.github.matywaky.inventory.repository.RoleRepository;
import com.github.matywaky.inventory.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
