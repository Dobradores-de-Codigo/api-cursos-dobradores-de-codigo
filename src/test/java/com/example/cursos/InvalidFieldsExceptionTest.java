package com.example.cursos;

import com.example.cursos.exception.InvalidFieldsException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class InvalidFieldsExceptionTest {

    @Test
    public void testInvalidFieldsExceptionMessage() {
        String message = "Campos inválidos";
        InvalidFieldsException exception = new InvalidFieldsException(message);

        assertEquals(message, exception.getMessage());
    }

    @Test
    public void testInvalidFieldsExceptionBindingResult() {
        InvalidFieldsException exception = new InvalidFieldsException("Campos inválidos");

        assertNull(exception.getBindingResult());
    }

    @Test
    public void testInvalidFieldsExceptionHttpStatus() {
        InvalidFieldsException exception = new InvalidFieldsException("Campos inválidos");

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, exception.getStatus());
    }
    // asdf
}
