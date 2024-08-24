package com.univalle.todo.DTO.tarea;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TareaDTO(@NotBlank(message = "Ingrese un nombre") String nombre,
                       @NotBlank(message = "Ingrese una descripcion") String descripcion,
                       @NotNull(message = "Debes enviar el creador de la tarea") Integer idCreador) {
}
