package com.univalle.todo.controllers.privates;

import com.univalle.todo.DTO.tarea.TareaDTO;
import com.univalle.todo.services.ITareaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tareas")
@AllArgsConstructor
@PreAuthorize("isAuthenticated()")
public class TareasController {

    private ITareaService tareaService;

    @GetMapping
    public ResponseEntity<List<TareaDTO>> getTareas() {
        return new ResponseEntity<>(tareaService.listarTareas(), HttpStatus.OK) ;
    }
}
