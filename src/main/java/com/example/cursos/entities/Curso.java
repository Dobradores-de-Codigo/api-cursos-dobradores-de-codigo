package com.example.cursos.entities;


import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@Getter @Setter @RequiredArgsConstructor @Data
@Entity
@Table(name = "cursos")
@EntityListeners(AuditingEntityListener.class)
public class Curso implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome", nullable = false, unique = true, length = 100)
    private String nome;
    @Column(name = "horas", nullable = false, length = 100)
    private int horas;
    @Column(name = "professor", nullable = false, length = 100)
    private String professor;
    @Enumerated(EnumType.STRING)
    @Column(name = "areaConhecimento", nullable = false, length = 100)
    private AreaConhecimento areaConhecimento;
    @Column(name = "ativo", nullable = false, length = 100)
    private Boolean ativo = true;

    public boolean isAtivo() {
        return this.ativo;
    }

    public String getUsername() {
        return this.nome;
    }

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

    @Override
    public String toString() {
        return "Curso(" + "id=" + id +
                ", nome='" + nome + '\'' +
                ", horas=" + horas +
                ", professor='" + professor + '\'' +
                ", areaConhecimento=" + areaConhecimento +
                ", ativo=" + ativo +
                ')';
    }
}
