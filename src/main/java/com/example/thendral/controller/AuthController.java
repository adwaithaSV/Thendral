package com.example.thendral.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.thendral.service.UserService;
import com.example.thendral.dto.UserDto;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody UserDto userDto) {
        return userService.registerUser(userDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto) {
        return userService.loginUser(userDto);
    }
}
