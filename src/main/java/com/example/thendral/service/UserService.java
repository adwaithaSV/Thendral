package com.example.thendral.service;

import com.example.thendral.dto.UserDto;

public interface UserService {
    String registerUser(UserDto userDto);
    String loginUser(UserDto userDto);
}
