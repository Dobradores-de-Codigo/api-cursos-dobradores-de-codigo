package com.example.cursos;

import com.example.cursos.exception.CursoUniqueViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CursoUniqueViolationExceptionTest {

    @Test
    public void testCursoUniqueViolationExceptionMessage() {
        String message = "O curso já existe";
        CursoUniqueViolationException exception = new CursoUniqueViolationException(message);

        assertEquals(message, exception.getMessage());
    }

    @Test
    public void testCursoUniqueViolationExceptionHttpStatus() {
        CursoUniqueViolationException exception = new CursoUniqueViolationException("O curso já existe");

        assertEquals(HttpStatus.CONFLICT, exception.getStatus());
    }
}
