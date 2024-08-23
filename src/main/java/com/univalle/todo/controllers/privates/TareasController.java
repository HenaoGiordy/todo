package com.univalle.todo.controllers.privates;

import com.univalle.todo.entities.Tareas;
import com.univalle.todo.repository.TareasRepository;
import lombok.AllArgsConstructor;
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

    private TareasRepository tareasRepository;

    @GetMapping
    public List<Tareas> getTareas() {
        return tareasRepository.findAll();
    }
}
