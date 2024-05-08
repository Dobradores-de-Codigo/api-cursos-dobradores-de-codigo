package com.example.cursos.entities;


import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "horas", nullable = false, length = 100)
    private Date horas;
    @Column(name = "professor", nullable = false, length = 100)
    private String professor;
    @Column(name = "areaConhecimento", nullable = false, length = 100)
    private AreaConhecimento areaConhecimento;
    @Column(name = "ativo", nullable = false, length = 100)
    private Boolean ativo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
