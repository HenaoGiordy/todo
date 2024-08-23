package com.univalle.todo.entities;

import com.univalle.todo.DTO.tarea.TareaDTO;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Debes ingresar un nombre")
    private String nombre;

    @NotNull(message = "Debes ingresar una descripcion")
    private String descripcion;

    private Boolean completado = false;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Tareas(TareaDTO tareaDTO) {
        this.nombre = tareaDTO.nombre();
        this.descripcion = tareaDTO.descripcion();
    }
}
