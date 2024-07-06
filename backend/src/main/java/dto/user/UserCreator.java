package dto.user;

import enums.Roles;

public record UserCreator(String username, String email, String cpf, Roles role, String cep,String street, String neighborhood, String housenumber) {}
