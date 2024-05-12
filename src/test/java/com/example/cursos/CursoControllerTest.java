package com.example.cursos;


import com.example.cursos.entities.Curso;
import com.example.cursos.service.CursoService;
import com.example.cursos.web.dto.CursoCreateDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Collections;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CursoService cursoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCadastrarCurso() throws Exception {
        CursoCreateDto cursoCreateDto = new CursoCreateDto();
        cursoCreateDto.setNome("Curso de Teste");

        Curso cursoMock = new Curso();
        cursoMock.setId(1L);
        cursoMock.setNome("Curso de Teste");

        Mockito.when(cursoService.salvar(Mockito.any(Curso.class))).thenReturn(cursoMock);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/cursos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cursoCreateDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nome").value("Curso de Teste"));
    }

    @Test
    public void testGetAll() throws Exception {
        Curso cursoMock = new Curso();
        cursoMock.setId(1L);
        cursoMock.setNome("Curso de Teste");

        Mockito.when(cursoService.findAll()).thenReturn(Collections.singletonList(cursoMock));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cursos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nome").value("Curso de Teste"));
    }
    // asdf
}