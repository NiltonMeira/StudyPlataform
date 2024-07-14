package com.example.backend.interfaces;

import com.example.backend.dto.user.UserCreatorDto;
import com.example.backend.dto.user.UpdatePasswordDto;
import com.example.backend.model.User;

import java.security.SecureRandom;
import java.util.List;

public interface UserInterface {
    Boolean verifyUser(String username, String email);
    Boolean verifyPassword(String password);
    Boolean verifyEmail(String email);
    List<User> findByUsername(String username);
    List<User> findByEmail(String email);
    User newUser(UserCreatorDto userCreator);
    String changePassword(UpdatePasswordDto updatePasswordDto, String token);

}

