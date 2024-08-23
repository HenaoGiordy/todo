package com.univalle.todo.controllers.privates;

import com.univalle.todo.DTO.tarea.TareaDTO;
import com.univalle.todo.DTO.tarea.TareaListDTO;
import com.univalle.todo.services.ITareaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
@AllArgsConstructor
@PreAuthorize("isAuthenticated()")
public class TareasController {

    private ITareaService tareaService;

    @GetMapping("/{id}")
    public ResponseEntity<List<TareaListDTO>> getTareas(@PathVariable Integer id) {
        return new ResponseEntity<>(tareaService.listarTareas(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TareaDTO> createTarea(@Valid @RequestBody TareaDTO tareaDTO) {
        return new ResponseEntity<>(tareaService.crearTarea(tareaDTO), HttpStatus.CREATED) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable Integer id) {
        tareaService.eliminarTarea(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;
    }
}
