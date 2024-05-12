package com.example.cursos;

import com.example.cursos.entities.AreaConhecimento;
import com.example.cursos.entities.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CursoTest {

    @Test
    public void testCursoEquals() {
        Curso curso1 = new Curso();
        curso1.setId(1L);

        Curso curso2 = new Curso();
        curso2.setId(1L);

        Curso curso3 = new Curso();
        curso3.setId(2L);

        Assertions.assertEquals(curso1, curso2);
        Assertions.assertNotEquals(curso1, curso3);
    }

    @Test
    public void testCursoHashCode() {
        Curso curso1 = new Curso();
        curso1.setId(1L);

        Curso curso2 = new Curso();
        curso2.setId(1L);

        Curso curso3 = new Curso();
        curso3.setId(2L);

        Assertions.assertEquals(curso1.hashCode(), curso2.hashCode());
        Assertions.assertNotEquals(curso1.hashCode(), curso3.hashCode());
    }

    @Test
    public void testCursoGetUsername() {
        Curso curso = new Curso();
        curso.setNome("Curso de Java");

        Assertions.assertEquals("Curso de Java", curso.getUsername());
    }

    @Test
    public void testCursoSettersAndGetters() {
        Curso curso = new Curso();

        curso.setId(1L);
        curso.setNome("Curso de Java");
        curso.setHoras(40);
        curso.setProfessor("Professor X");
        curso.setAreaConhecimento(AreaConhecimento.TI);
        curso.setAtivo(true);

        Assertions.assertEquals(1L, curso.getId());
        Assertions.assertEquals("Curso de Java", curso.getNome());
        Assertions.assertEquals(40, curso.getHoras());
        Assertions.assertEquals("Professor X", curso.getProfessor());
        Assertions.assertEquals(AreaConhecimento.TI, curso.getAreaConhecimento());
        Assertions.assertEquals(true, curso.getAtivo());
    }

    @Test
    public void testCursoToString() {
        Curso curso = new Curso();

        curso.setId(1L);
        curso.setNome("Curso de Marketing");
        curso.setHoras(40);
        curso.setProfessor("Professor X");
        curso.setAreaConhecimento(AreaConhecimento.MARKETING);
        curso.setAtivo(true);

        String expected = "Curso(id=1, nome='Curso de Marketing', horas=40, professor='Professor X', areaConhecimento=MARKETING, ativo=true)";

        Assertions.assertEquals(expected, curso.toString());
    }

    @Test
    public void testCursoNewInstance() {
        Curso curso = Mockito.mock(Curso.class);

        Mockito.when(curso.getId()).thenReturn(1L);
        Mockito.when(curso.getNome()).thenReturn("Curso de FINANCAS");
        Mockito.when(curso.getHoras()).thenReturn(40);
        Mockito.when(curso.getProfessor()).thenReturn("Professor X");
        Mockito.when(curso.getAreaConhecimento()).thenReturn(AreaConhecimento.FINANCAS);
        Mockito.when(curso.getAtivo()).thenReturn(true);

        Assertions.assertEquals(1L, curso.getId());
        Assertions.assertEquals("Curso de FINANCAS", curso.getNome());
        Assertions.assertEquals(40, curso.getHoras());
        Assertions.assertEquals("Professor X", curso.getProfessor());
        Assertions.assertEquals(AreaConhecimento.FINANCAS, curso.getAreaConhecimento());
        Assertions.assertEquals(true, curso.getAtivo());
    }
}