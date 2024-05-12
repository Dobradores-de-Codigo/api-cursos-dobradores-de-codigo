package com.example.cursos;

import com.example.cursos.entities.AreaConhecimento;
import com.example.cursos.entities.Curso;
import com.example.cursos.repository.CursoRepository;
import com.example.cursos.service.CursoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoService cursoService;

    @Test
    @DisplayName("Teste findAll")
    public void testFindAll() {

        List<Curso> cursos = List.of(
                new Curso(1L, "Curso 1", 100, "Professor 1", AreaConhecimento.TI, true),
                new Curso(2L, "Curso 2", 120, "Professor 2", AreaConhecimento.TI, true),
                new Curso(3L, "Curso 3", 150, "Professor 3", AreaConhecimento.TI, true)
        );

        when(cursoRepository.findAll()).thenReturn(cursos);
        List<Curso> cursosRetornados = cursoService.findAll();

        assertNotNull(cursosRetornados);
        assertEquals(3, cursosRetornados.size());
    }

    @Test
    @DisplayName("Teste findById")
    public void testFindById() {

        Curso curso = new Curso(1L, "Curso 1", 100, "Professor 1", AreaConhecimento.TI, true);
        Optional<Curso> optionalCurso = Optional.of(curso);
        when(cursoRepository.findById(1L)).thenReturn(optionalCurso);

        Optional<Curso> cursoOptional = Optional.ofNullable(cursoService.findById(1L));

        assertAll(
                () -> assertNotNull(cursoOptional),
                () -> assertEquals(1L, cursoOptional.get().getId()),
                () -> assertEquals("Curso 1", cursoOptional.get().getNome()),
                () -> assertEquals(100, cursoOptional.get().getHoras()),
                () -> assertEquals("Professor 1", cursoOptional.get().getProfessor()),
                () -> assertEquals(AreaConhecimento.TI, cursoOptional.get().getAreaConhecimento()),
                () -> assertTrue(cursoOptional.get().isAtivo())
        );
    }

    @Test
    @DisplayName("Teste save")
    public void testSave() {

        AreaConhecimento areaConhecimento = AreaConhecimento.TI;
        Curso curso = new Curso(null, "Curso 4", 150, "Professor 4", areaConhecimento, true);
        when(cursoRepository.save(curso)).thenReturn(curso);

        Curso saved = cursoService.salvar(curso);

        assertNotNull(saved);
        assertEquals("Curso 4", saved.getNome());
        assertEquals(150, saved.getHoras());
        assertEquals("Professor 4", saved.getProfessor());
        assertEquals(areaConhecimento, saved.getAreaConhecimento());
        assertTrue(saved.isAtivo());

        verify(cursoRepository, Mockito.times(1)).save(curso);
    }

    @Test
    @DisplayName("Teste delete")
    public void testDelete() {

        Curso curso = new Curso(1L, "Curso 1", 100, "Professor 1", AreaConhecimento.TI, true);
        when(cursoRepository.findById(1L)).thenReturn(Optional.of(curso));

        cursoService.delete(curso);

        verify(cursoRepository, Mockito.times(1)).delete(curso);
    }

}
