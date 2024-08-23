package com.univalle.todo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Tareas {
    @Id
    private Integer id;

    @NotNull(message = "Debes ingresar un nombre")
    private String nombre;

    @NotNull(message = "Debes ingresar una descripcion")
    private String descripcion;

    private Boolean completado = false;

}
