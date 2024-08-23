package com.univalle.todo.services;

import com.univalle.todo.DTO.tarea.EditTareaDTO;
import com.univalle.todo.DTO.tarea.TareaDTO;
import com.univalle.todo.repository.TareasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TareaServiceImp implements ITareaService {

    private TareasRepository tareasRepository;

    @Override
    public TareaDTO crearTarea(TareaDTO tarea) {
        return null;
    }

    @Override
    public EditTareaDTO modificarTarea(EditTareaDTO tarea) {
        return null;
    }

    @Override
    public List<TareaDTO> listarTareas() {
        return tareasRepository.findAll().stream().map(tareas ->
                new TareaDTO(tareas.getNombre(),
                        tareas.getDescripcion()))
                .toList();
    }

    @Override
    public void eliminarTarea(Long id) {

    }
}
