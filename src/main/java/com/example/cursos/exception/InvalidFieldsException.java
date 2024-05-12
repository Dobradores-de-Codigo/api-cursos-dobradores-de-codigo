package com.example.cursos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidFieldsException extends RuntimeException {

    private final HttpStatus status;

    public InvalidFieldsException(String message) {
        this(message, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public InvalidFieldsException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public BindingResult getBindingResult() {
        return null;
    }

    public HttpStatus getStatus() {
        return status;
    }
}