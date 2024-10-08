package com.example.cursos.web.exception;

import com.example.cursos.exception.CursoUniqueViolationException;
import com.example.cursos.exception.InvalidFieldsException;
import com.example.cursos.exception.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(CursoUniqueViolationException.class)
    public ResponseEntity<ErrorMessage> uniqueViolationException(RuntimeException ex,
                                                                 HttpServletRequest request){
        log.error("Api Error -", ex);
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.CONFLICT, ex.getMessage()));

    }
    @ExceptionHandler(InvalidFieldsException.class)
    public ResponseEntity<ErrorMessage> invalidFieldsException(InvalidFieldsException ex,
                                                               HttpServletRequest request) {
        log.error("Api Error -", ex);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, ex.getMessage(), ex.getBindingResult()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessage> entityNotFoundException(RuntimeException ex, HttpServletRequest request) {
        log.error("Api Error -", ex);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.NOT_FOUND, ex.getMessage()));
    }

}
