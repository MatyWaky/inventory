package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.User;
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
    private final PasswordEncoder passwordEncoder;

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    public String dataCommunicate(String email, String password, String repeatedPassword) {
        if (arePasswordsDifferent(password, repeatedPassword)) {
            return "Passwords do not match";
        } else if(isPasswordInvalid(password)) {
            return "Password do not match requirements";
        } else if (isEmailInvalid(email)) {
            return "Email address is not valid";
        }
        
        return null;
    }

    private boolean arePasswordsDifferent(String password, String repeatedPassword) {
        return !password.equals(repeatedPassword);
    }

    private boolean isPasswordInvalid(String password) {
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,32}$";
        /*
        (?=.*[a-z]) — min. 1 lowercase letter
        (?=.*[A-Z]) — min. 1 Uppercase letter
        (?=.*\\d) — min. 1 digit
        (?=.*[!@#$%^&*]) — min. 1 special character !@#$%^&*
        [A-Za-z\\d!@#$%^&*]{8,32} — min. 8, max. 32 characters
        */
        return password.matches(pattern);
    }

    private boolean isEmailInvalid(String email) {
        String pattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        /*
        ^[a-zA-Z0-9_+&*-]+ — first part (before @) can contain only letters, digits and special chars _+&*-
        (?:\\.[a-zA-Z0-9_+&*-]+)* — email can contain dots
        @ — @ symbol is required
        (?:[a-zA-Z0-9-]+\\.)+ — domain must contain at least one part before dot (example.)
        [a-zA-Z]{2,7}$ — end of domain must have min. 2 to 7 letters
        */
        return email.matches(pattern);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
