package com.example.cursos.web.controller;

import com.example.cursos.entities.Curso;
import com.example.cursos.service.CursoService;
import com.example.cursos.web.dto.CursoCreateDto;
import com.example.cursos.web.dto.CursoProfessorDto;
import com.example.cursos.web.dto.CursoResponseDto;
import com.example.cursos.web.dto.mapper.CursoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/cursos")
public class CursoController {

    private final CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoResponseDto> cadastrarCurso(@Valid @RequestBody CursoCreateDto createDto){
        Curso curso = cursoService.salvar(CursoMapper.toCurso(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(CursoMapper.toDto(curso));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<CursoResponseDto> updateProfessor(@PathVariable Long id, @RequestBody CursoProfessorDto dto) {
        Curso curso = cursoService.editarProfessor(id, dto.getNovoProfessor());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(CursoMapper.toDto(curso));
    }
    @GetMapping
    public ResponseEntity<List<CursoResponseDto>> getAll() {
        List<Curso> cursos = cursoService.buscarTodos();
        return ResponseEntity.ok(CursoMapper.toListDto(cursos));
    }

    /*@Operation(summary = "Recuperar um curso pelo id", description = "Recuperar um curso pelo id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Recurso recuperado com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CursoResponseDto.class))),
                    @ApiResponse(responseCode = "404", description = "Recurso não encontrado",
                            content = @Content(mediaType = "application/json",schema = @Schema(implementation = ErrorMessage.class)))
            })*/

}