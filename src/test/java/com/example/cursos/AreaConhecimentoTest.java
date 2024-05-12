package com.example.cursos;

import com.example.cursos.entities.AreaConhecimento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaConhecimentoTest {

    @Test
    public void testAreaConhecimentoValues() {

        AreaConhecimento[] values = AreaConhecimento.values();

        assertEquals(5, values.length);
        assertEquals("TI", values[0].name());
        assertEquals("MARKETING", values[1].name());
        assertEquals("FINANCAS", values[2].name());
        assertEquals("RH", values[3].name());
        assertEquals("OUTROS", values[4].name());
    }

    @Test
    public void testAreaConhecimentoFromString() {

        AreaConhecimento ti = AreaConhecimento.valueOf("TI");
        AreaConhecimento marketing = AreaConhecimento.valueOf("MARKETING");
        AreaConhecimento financas = AreaConhecimento.valueOf("FINANCAS");
        AreaConhecimento rh = AreaConhecimento.valueOf("RH");
        AreaConhecimento outros = AreaConhecimento.valueOf("OUTROS");

        assertEquals("TI", ti.name());
        assertEquals("MARKETING", marketing.name());
        assertEquals("FINANCAS", financas.name());
        assertEquals("RH", rh.name());
        assertEquals("OUTROS", outros.name());
    }

    @Test
    public void testAreaConhecimentoFromInvalidString() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AreaConhecimento invalido = AreaConhecimento.valueOf("INVALIDO");
        });
    }
    // asdf
}