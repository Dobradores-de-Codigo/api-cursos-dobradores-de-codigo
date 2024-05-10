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
        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new CursoUniqueViolationException(String.format("Curso {%s} já cadastrado", curso.getUsername()));
        }
    }

    @Transactional(readOnly = true)
    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Curso id=%s não encontrado.", id))
        );
    }

    @Transactional
    public Curso editarProfessor(Long id, String novoProfessor) {
        Curso curso = buscarPorId(id);

        curso.setProfessor(novoProfessor);
        return curso;
    }

    @Transactional(readOnly = true)
    public List<Curso> buscarTodos() {
        return cursoRepository.findAll();
    }

    @Transactional
    public Curso inabilitarCurso(Long id) {
        Curso curso = buscarPorId(id);
        curso.setAtivo(false);
        return curso;
    }
}