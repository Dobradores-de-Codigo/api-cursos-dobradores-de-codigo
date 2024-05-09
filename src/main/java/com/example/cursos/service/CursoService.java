package com.example.cursos.service;


import com.example.cursos.exception.CursoUniqueViolationException;
import com.example.cursos.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.cursos.entities.Curso;
import com.example.cursos.repository.CursoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    @Transactional
    public Curso salvar(Curso curso) {
        try {
            return cursoRepository.save(curso);
        } catch (org.springframework.dao.DataIntegrityViolationException ex){
            throw  new CursoUniqueViolationException(String.format("Curso {%s} já cadastrado", curso.getUsername()));
        }
    }
}