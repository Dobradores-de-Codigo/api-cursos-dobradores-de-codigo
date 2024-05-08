package com.example.cursos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cursos.dto.CursoDTO;
import com.example.cursos.entities.Curso;
import com.example.cursos.exception.AlreadyExistsException;
import com.example.cursos.exception.NotFoundException;
import com.example.cursos.mapper.CursoMapper;
import com.example.cursos.repository.CursoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoDTO> listarCursos() {
        List<Curso> cursos = cursoRepository.findAll();
        return cursos.stream()
                .map(CursoMapper.INSTANCE::cursoToCursoDTO)
                .collect(Collectors.toList());
    }

    public CursoDTO criarCurso(CursoDTO cursoDTO) {
        if (cursoRepository.existsByNome(cursoDTO.getNome())) {
            throw new AlreadyExistsException("Curso já cadastrado no sistema");
        }
        Curso curso = CursoMapper.INSTANCE.cursoDTOToCurso(cursoDTO);
        curso = cursoRepository.save(curso);
        return CursoMapper.INSTANCE.cursoToCursoDTO(curso);
    }

    public CursoDTO buscarCursoPorId(Long id) {
        Curso curso = cursoRepository.findById(id).orElseThrow(() -> new NotFoundException("Curso não encontrado"));
        return CursoMapper.INSTANCE.cursoToCursoDTO(curso);
    }

    public CursoDTO atualizarCurso(Long id, CursoDTO cursoDTO) {
        Curso curso = cursoRepository.findById(id).orElseThrow(() -> new NotFoundException("Curso não encontrado"));
        if (!cursoDTO.getNome().equals(curso.getNome()) &&
                cursoRepository.existsByNome(cursoDTO.getNome())) {
            throw new AlreadyExistsException("Curso já cadastrado no sistema");
        }
        curso = CursoMapper.INSTANCE.cursoDTOToCurso(cursoDTO);
        curso.setId(id);
        curso = cursoRepository.save(curso);
        return CursoMapper.INSTANCE.cursoToCursoDTO(curso);
    }

    public void deletarCurso(Long id) {
        if (!cursoRepository.existsById(id)) {
            throw new NotFoundException("Curso não encontrado");
        }
        cursoRepository.deleteById(id);
    }
}