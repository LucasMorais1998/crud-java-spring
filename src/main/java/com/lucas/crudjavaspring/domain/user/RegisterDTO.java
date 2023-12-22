package com.lucas.crudjavaspring.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
