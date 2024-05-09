package com.example.cursos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CursoUniqueViolationException extends RuntimeException {

    public CursoUniqueViolationException(String message) {
        super(message);
    }
}