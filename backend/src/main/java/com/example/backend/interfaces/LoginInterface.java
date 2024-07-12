package com.example.backend.interfaces;

import com.example.backend.dto.UserLoginDto;

public interface LoginInterface {
    void checkLogin(String email);
    String doLogin(UserLoginDto userLoginDto);
}
