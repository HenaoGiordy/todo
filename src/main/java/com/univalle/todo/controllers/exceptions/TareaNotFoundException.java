package com.univalle.todo.controllers.exceptions;

public class TareaNotFoundException extends RuntimeException {
    public TareaNotFoundException(String message) {
        super(message);
    }
}
