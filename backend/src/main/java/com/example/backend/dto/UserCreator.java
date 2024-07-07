package com.example.backend.dto;

import com.example.backend.enums.Roles;

public record UserCreator(String username, String email, String cpf, Roles role, String cep, String street, String neighborhood, String housenumber) {}
