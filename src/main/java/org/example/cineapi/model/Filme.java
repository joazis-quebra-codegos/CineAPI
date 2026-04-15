package org.example.cineapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "titulo é obrigatório")
    private String titulo;

    @NotBlank(message = "Gênero é obrigatório")
    private String genero;

    @NotBlank(message = "Diretor é obrigatório")
    private String diretor;

    @NotNull(message = "Ano é obrigatório")
    @Min(value = 1895)
    @Max(value = 2026)
    private Integer ano;

    @NotNull(message = "Duração é obrigatória")
    @Positive(message = "Duração tem que ser positiva")
    private Integer duracao;

    @Min(value = 0)
    @Max(value = 5)
    private Integer nota;

    public Filme(){}
}
