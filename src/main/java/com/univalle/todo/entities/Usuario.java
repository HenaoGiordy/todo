package com.univalle.todo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Usuario {
    @Id
    private Integer id;

    @Column(unique=true)
    @NotNull(message = "Debes ingresar un nombre")
    @NotBlank
    private String username;

    @NotNull(message = "Debes ingresar una password")
    @NotBlank
    private String password;

    @OneToMany
    private List<Tareas> tareas;
}
