package com.example.cursos;

import com.example.cursos.exception.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityNotFoundExceptionTest {

    @Test
    public void testEntityNotFoundExceptionMessage() {
        String message = "Entidade não encontrada";
        EntityNotFoundException exception = new EntityNotFoundException(message, HttpStatus.NOT_FOUND);

        assertEquals(message, exception.getMessage());
    }

    @Test
    public void testEntityNotFoundExceptionHttpStatus() {
        EntityNotFoundException exception = new EntityNotFoundException("Entidade não encontrada", HttpStatus.NOT_FOUND);

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
    }
}