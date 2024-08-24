package com.univalle.todo.DTO.tarea;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EditTareaDTO(
        @NotBlank(message = "Ingrese un nombre") String nombre,
        @NotBlank(message = "Ingrese una descripción") String decripcion,
        @NotNull(message = "Debes enviar el ID de la tarea") Integer id) {
}
