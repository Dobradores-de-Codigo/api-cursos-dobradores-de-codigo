package com.example.cursos.web.controller;

import com.example.cursos.entities.Curso;
import com.example.cursos.service.CursoService;
import com.example.cursos.web.dto.CursoCreateDto;
import com.example.cursos.web.dto.CursoProfessorDto;
import com.example.cursos.web.dto.CursoResponseDto;
import com.example.cursos.web.dto.mapper.CursoMapper;
import com.example.cursos.web.exception.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Cursos", description = "Contém todas as operações relativas aos recursos para cadastro, edição e leitura de um curso.")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/cursos")
public class CursoController {

    private final CursoService cursoService;

    @Operation(summary = "Cadastrar um novo curso", description = "Recurso para cadastrar um novo curso",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CursoResponseDto.class))),
                    @ApiResponse(responseCode = "409", description = "Curso já cadastrado no Sistema",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "422", description = "Recurso não processado por dados de entrada invalidos",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
            })
    @PostMapping
    public ResponseEntity<CursoResponseDto> cadastrarCurso(@Valid @RequestBody CursoCreateDto createDto){
        Curso curso = cursoService.salvar(CursoMapper.toCurso(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(CursoMapper.toDto(curso));
    }
    @Operation(summary = "Atualizar o professor de um curso existente", description = "Recurso para atualizar o professor de um curso existente",
            responses = {
                    @ApiResponse(responseCode = "202", description = "Professor atualizado com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CursoResponseDto.class))),
                    @ApiResponse(responseCode = "404", description = "Curso não encontrado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
            })
    @PatchMapping("/professor/{id}")
    public ResponseEntity<CursoResponseDto> atualizarProfessor(@PathVariable Long id, @RequestBody CursoProfessorDto dto) {
        Curso curso = cursoService.editarProfessor(id, dto.getNovoProfessor());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(CursoMapper.toDto(curso));
    }
    @Operation(summary = "Obter todos os cursos cadastrados", description = "Recurso para obter todos os cursos cadastrados",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de cursos obtida com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CursoResponseDto.class)))
            })
    @GetMapping
    public ResponseEntity<List<CursoResponseDto>> getAll() {
        List<Curso> cursos = cursoService.buscarTodos();
        return ResponseEntity.ok(CursoMapper.toListDto(cursos));
    }
    @Operation(summary = "Inativar um curso", description = "Endpoint para inativar um curso existente",
            responses = {
                    @ApiResponse(responseCode = "202", description = "Curso inativado com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CursoResponseDto.class))),
                    @ApiResponse(responseCode = "404", description = "Curso não encontrado")
            })
    @PatchMapping("/{id}")
    public ResponseEntity<CursoResponseDto> inabilitarCurso(@PathVariable Long id) {
        Curso curso = cursoService.inabilitarCurso(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(CursoMapper.toDto(curso));
    }

}