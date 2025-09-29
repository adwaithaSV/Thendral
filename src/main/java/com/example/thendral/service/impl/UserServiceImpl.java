package com.example.thendral.service.impl;

import com.example.thendral.dto.UserDto;
import com.example.thendral.model.User;
import com.example.thendral.repository.UserRepository;
import com.example.thendral.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String registerUser(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            return "Username already exists";
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setRoles(new HashSet<>());
        user.getRoles().add("USER");
        user.setEnabled(true);
        userRepository.save(user);
        return "User registered successfully";
    }

    @Override
    public String loginUser(UserDto userDto) {
        // Implement login logic or return a placeholder
        return "Login successful (placeholder)";
    }
}
