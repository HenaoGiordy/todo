package com.univalle.todo.services;

import com.univalle.todo.DTO.tarea.EditTareaDTO;
import com.univalle.todo.DTO.tarea.TareaDTO;

import java.util.List;

public interface ITareaService {
    TareaDTO crearTarea(TareaDTO tarea);
    EditTareaDTO modificarTarea(EditTareaDTO tarea);
    List<TareaDTO> listarTareas();
    void eliminarTarea(Long id);
}
