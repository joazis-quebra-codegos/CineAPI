package org.example.cineapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TBFILME")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFilme")
    private Long id;
    private String titulo;
    private String genero;
    private Integer ano;
    private Integer duracao;
    private Integer nota;

    @OneToMany(mappedBy = "filme")
    private List<Avaliacao> avaliacao;

    @ManyToOne
    @JoinColumn(name = "idDiretor")
    private Diretor diretor;


    public Filme(){}
}
