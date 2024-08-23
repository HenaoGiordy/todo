package com.univalle.todo.DTO.register;

import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(@NotBlank String username,@NotBlank String password) {
}
