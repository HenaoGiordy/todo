package com.univalle.todo.services;

import com.univalle.todo.DTO.tarea.EditTareaDTO;
import com.univalle.todo.DTO.tarea.TareaDTO;
import com.univalle.todo.DTO.tarea.TareaListDTO;
import com.univalle.todo.controllers.exceptions.TareaNotFoundException;
import com.univalle.todo.entities.Tareas;
import com.univalle.todo.entities.Usuario;
import com.univalle.todo.repository.TareasRepository;
import com.univalle.todo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TareaServiceImp implements ITareaService {

    private TareasRepository tareasRepository;
    private UserRepository userRepository;

    @Override
    public TareaDTO crearTarea(TareaDTO tareaDTO) {

        Optional<Usuario> usuarioOpt = userRepository.findById(tareaDTO.idCreador());

        if (usuarioOpt.isPresent()) {

            Usuario usuario = usuarioOpt.get();
            // Crear una nueva instancia de Tareas a partir de TareaDTO
            Tareas tarea = new Tareas(tareaDTO);

            // Establecer el usuario en la tarea
            tarea.setUsuario(usuario);

            // Guardar la tarea en la base de datos
            tareasRepository.save(tarea);

            // Devolver el DTO con la información de la tarea y el ID del usuario
            return new TareaDTO(tarea.getNombre(), tarea.getDescripcion(), tareaDTO.idCreador());
        } else {
            // Manejar el caso cuando el usuario no existe
            throw new UsernameNotFoundException("Usuario con ID " + tareaDTO.idCreador() + " no encontrado.");
        }
    }

    @Override
    public EditTareaDTO modificarTarea(EditTareaDTO tarea) {
        return null;
    }

    @Override
    public List<TareaListDTO> listarTareas(Integer id) {

            return tareasRepository.findAllByUsuarioId(id).stream().map(
                    tareas -> new TareaListDTO(tareas.getId(),  tareas.getNombre(), tareas.getDescripcion())
            ).toList();
        }

    @Override
    public void eliminarTarea(Integer id) {
        Optional<Tareas> tarea = tareasRepository.findById(id);

        if (tarea.isPresent()) {
            tareasRepository.delete(tarea.get());
        }else {
            throw new TareaNotFoundException("Tarea no encontrada");
        }
    }


}



