package com.univalle.todo.DTO.tarea;

import jakarta.validation.constraints.NotBlank;

public record TareaDTO(@NotBlank String nombre, @NotBlank String descripcion) {
}
