package org.example.cineapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TBAVALIACAO")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAvaliacao")
    private Long id;

    private Integer nota;
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "idFilme")
    private Filme filme;

    public Avaliacao(){}

    public Avaliacao(Integer nota, String comentario, Filme filme){
        this.nota = nota;
        this.comentario = comentario;
        this.filme = filme;
    }
}
