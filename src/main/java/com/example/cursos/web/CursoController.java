package com.example.cursos.web;

import com.example.cursos.entities.Curso;
import com.example.cursos.service.CursoService;
import com.example.cursos.web.dto.CursoCreateDto;
import com.example.cursos.web.dto.CursoResponseDto;
import com.example.cursos.web.dto.mapper.CursoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/cursos")
public class CursoController {

    private final CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoResponseDto> cadastrarCurso(@RequestBody CursoCreateDto createDto){
        Curso curso = cursoService.salvar(CursoMapper.toCurso(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(CursoMapper.toDto(curso));

}
}