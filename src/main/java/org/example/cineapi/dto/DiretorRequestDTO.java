package org.example.cineapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DiretorRequestDTO(
        @NotNull(message = "Nome é obrigatório")
        String nome,
        @NotNull(message = "Nacionalidade é obrigatória")
        String nacionalidade,
        @Min(value=18)
        @Max(value=121)
        Integer idade,
        String biografia
) {}
