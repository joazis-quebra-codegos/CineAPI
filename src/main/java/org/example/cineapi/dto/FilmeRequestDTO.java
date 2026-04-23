package org.example.cineapi.dto;

import jakarta.validation.constraints.*;

public record FilmeRequestDTO(

        @NotBlank(message = "titulo é obrigatório")
        String titulo,

        @NotBlank(message = "Gênero é obrigatório")
        String genero,

        @NotBlank(message = "Diretor é obrigatório")
        String diretor,

        @NotNull(message = "Ano é obrigatório")
        @Min(value = 1895)
        @Max(value = 2026)
        Integer ano,

        @NotNull(message = "Duração é obrigatória")
        @Positive(message = "Duração tem que ser positiva")
        Integer duracao,

        @Min(value = 0)
        @Max(value = 5)
        Integer nota
) {}
