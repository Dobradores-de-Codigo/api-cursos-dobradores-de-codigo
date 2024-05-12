package com.example.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cursos.entities.Curso;

import java.util.List;


public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findAll();
}