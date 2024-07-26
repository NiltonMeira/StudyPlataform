package com.example.backend.dto.user;

public record UpdatePasswordDto(String email,
                                String oldPassword,
                                String newPassword) {
}
