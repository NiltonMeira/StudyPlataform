package com.example.backend.dto.user;

import com.example.backend.enums.Roles;

public record UserCreatorDto(
        String username,
        String email,
        String cpf,
        Roles role,
        String cep,
        String street,
        String neighborhood,
        String housenumber) {
}
