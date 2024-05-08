package com.example.cursos.web.dto.mapper;

import com.example.cursos.entities.Curso;
import com.example.cursos.web.dto.CursoCreateDto;
import com.example.cursos.web.dto.CursoResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CursoMapper {

        public static Curso toCurso(CursoCreateDto dto){
            return new ModelMapper().map(dto, Curso.class);
        }
        public static CursoResponseDto toDto(Curso curso){
            return new ModelMapper().map(curso, CursoResponseDto.class);
        }
}
