package com.example.cursos.web.dto;

import com.example.cursos.entities.AreaConhecimento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CursoResponseDto {

    private Long id;
    private String nome;
    private int horas;
    private String professor;
    private AreaConhecimento areaConhecimento;
    private Boolean ativo;
}
