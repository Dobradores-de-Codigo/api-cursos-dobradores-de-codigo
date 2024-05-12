package com.example.cursos.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CursoUniqueViolationException extends RuntimeException {

    @Getter
    private final HttpStatus status = HttpStatus.CONFLICT;

    public CursoUniqueViolationException(String message) {
        super(message);
    }
}