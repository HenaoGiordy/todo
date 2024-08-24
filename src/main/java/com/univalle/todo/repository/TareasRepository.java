package com.univalle.todo.repository;

import com.univalle.todo.entities.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TareasRepository extends JpaRepository<Tareas, Integer> {

    List<Tareas> findAllByUsuarioId(Integer id);
}

