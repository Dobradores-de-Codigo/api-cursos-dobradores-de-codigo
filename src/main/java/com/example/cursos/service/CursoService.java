package com.example.cursos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.cursos.entities.Curso;
import com.example.cursos.repository.CursoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

    @Transactional
    public Curso salvar(Curso curso) {
        return cursoRepository.save(curso);
    }

}