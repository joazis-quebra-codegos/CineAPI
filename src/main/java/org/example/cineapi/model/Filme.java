package org.example.cineapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "TBFILME")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilme;

    private String titulo;

    private String genero;

    private Integer ano;

    private Integer duracao;

    private Integer nota;

    @ManyToOne
    @JoinColumn(name = "idDiretor")
    private Diretor diretor;


    public Filme(){}
}
