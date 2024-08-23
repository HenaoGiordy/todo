package com.univalle.todo.repository;

import com.univalle.todo.entities.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareasRepository extends JpaRepository<Tareas, Integer> {
}
