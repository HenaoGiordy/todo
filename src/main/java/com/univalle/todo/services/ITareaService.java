package com.univalle.todo.services;

import com.univalle.todo.DTO.tarea.EditTareaDTO;
import com.univalle.todo.DTO.tarea.TareaDTO;
import com.univalle.todo.DTO.tarea.TareaListDTO;

import java.util.List;

public interface ITareaService {
    TareaDTO crearTarea(TareaDTO tarea);
    EditTareaDTO modificarTarea(Integer id, EditTareaDTO editTareaDTO);
    List<TareaListDTO> listarTareas(Integer id);
    void eliminarTarea(Integer id);
}
