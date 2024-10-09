package com.github.matywaky.inventory.service;

import com.github.matywaky.inventory.model.Employee;
import com.github.matywaky.inventory.model.Role;
import com.github.matywaky.inventory.model.User;
import com.github.matywaky.inventory.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl extends BasicJpaServiceImpl<User, Integer> implements UserService {

    private final RoleService roleService;
    private final EmployeeService employeeService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleService roleService,
                           EmployeeService employeeService,
                           PasswordEncoder passwordEncoder) {
        super(userRepository);
        this.roleService = roleService;
        this.employeeService = employeeService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Role> findAllRoles() {
        return roleService.findAll();
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeService.findAll();
    }

    @Override
    public String addUser(User user, String repeatedPassword, Integer roleId, Integer employeeId) {
        String error;
        if ((error = isEmailValid(user.getEmail())) != null) {
            return error;
        } else if ((error = checkPasswords(user.getPassword(), repeatedPassword)) != null) {
            return error;
        }

        Role role = searchRoleById(roleId);
        if (role == null) {
            return "Role not found";
        }
        user.setRole(role);

        Employee employee = searchEmployeeById(employeeId);
        if (employee == null) {
            return "Employee not found";
        }
        user.setEmployee(employee);

        saveUser(user);
        return null;
    }

    private String isEmailValid(String email) {
        String pattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        /*
        ^[a-zA-Z0-9_+&*-]+ — first part (before @) can contain only letters, digits and special chars _+&*-
        (?:\\.[a-zA-Z0-9_+&*-]+)* — email can contain dots
        @ — @ symbol is required
        (?:[a-zA-Z0-9-]+\\.)+ — domain must contain at least one part before dot (example.)
        [a-zA-Z]{2,7}$ — end of domain must have min. 2 to 7 letters
        */
        return email.matches(pattern)?null:"Email address is not valid";
    }

    private String checkPasswords(String password, String repeatedPassword) {
        if (!password.equals(repeatedPassword)) {
            return "Passwords do not match";
        }

        String error = isPasswordValid(password);
        if(error != null) {
            return "Password does not match the requirements";
        }

        return null;
    }

    private String isPasswordValid(String password) {
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,32}$";
        /*
        (?=.*[a-z]) — min. 1 lowercase letter
        (?=.*[A-Z]) — min. 1 Uppercase letter
        (?=.*\\d) — min. 1 digit
        (?=.*[!@#$%^&*]) — min. 1 special character !@#$%^&*
        [A-Za-z\\d!@#$%^&*]{8,32} — min. 8, max. 32 characters
        */
        return password.matches(pattern)?null:"Password do not match requirements";
    }

    private void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        save(user);
    }

    private Role searchRoleById(Integer id) {
        return roleService.findById(id);
    }

    private Employee searchEmployeeById(Integer id) {
        return employeeService.findById(id);
    }
}
