package com.example.cursos.web.dto;

import com.example.cursos.entities.AreaConhecimento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class CursoCreateDto {

    private String nome;
    private int horas;
    private String professor;
    @Enumerated(EnumType.STRING)
    private AreaConhecimento areaConhecimento;

}
