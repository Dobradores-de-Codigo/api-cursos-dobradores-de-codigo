package com.example.cursos.web.dto;

import com.example.cursos.entities.AreaConhecimento;
import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class CursoCreateDto {

    private String nome;
    private Date horas;
    private String professor;
    private AreaConhecimento areaConhecimento;
    private Boolean ativo;

}
