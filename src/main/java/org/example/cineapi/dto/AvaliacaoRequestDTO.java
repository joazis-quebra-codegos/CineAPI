package org.example.cineapi.dto;

import jakarta.validation.constraints.NotNull;

public record AvaliacaoRequestDTO (
        @NotNull(message = "Nota é obrigatória")
        Integer nota,
        String comentario,
        @NotNull(message = "Filme é obrigatório")
        Long idFilme
){}
