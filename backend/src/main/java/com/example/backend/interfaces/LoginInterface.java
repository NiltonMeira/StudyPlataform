package com.example.backend.interfaces;

import com.example.backend.dto.UserLoginDto;

public interface LoginInterface {
    Boolean checkLogin(String email, String password);
    String doLogin(UserLoginDto userLoginDto);
}
