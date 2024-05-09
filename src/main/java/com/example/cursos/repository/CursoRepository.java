package com.example.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cursos.entities.Curso;


public interface CursoRepository extends JpaRepository<Curso, Long> {

}