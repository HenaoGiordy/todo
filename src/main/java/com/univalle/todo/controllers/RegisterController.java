package com.univalle.todo.controllers;

import com.univalle.todo.DTO.register.RegisterRequest;
import com.univalle.todo.DTO.register.RegisterResponse;
import com.univalle.todo.services.UserDetailServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/register")
@RestController
@AllArgsConstructor
public class RegisterController {

    private UserDetailServiceImp userDetailServiceImp;

    @PostMapping()
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(userDetailServiceImp.register(registerRequest), HttpStatus.CREATED);
    }
}
