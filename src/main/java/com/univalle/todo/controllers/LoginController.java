package com.univalle.todo.controllers;

import com.univalle.todo.DTO.auth.AuthRequest;
import com.univalle.todo.DTO.auth.AuthResponse;
import com.univalle.todo.services.UserDetailServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private UserDetailServiceImp userDetailServiceImp;

    @PostMapping
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request){
        return new ResponseEntity<>(userDetailServiceImp.login(request), HttpStatus.OK);
    }
}
