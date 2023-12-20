package com.lucas.crudjavaspring.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequestDTO(
        String id,
        @NotBlank
        String name,
        @NotNull
        Integer price) {
}
