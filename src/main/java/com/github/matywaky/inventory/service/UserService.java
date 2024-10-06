package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    String dataCommunicate(String email, String password, String repeatedPassword);
    List<User> getAllUsers();
}
