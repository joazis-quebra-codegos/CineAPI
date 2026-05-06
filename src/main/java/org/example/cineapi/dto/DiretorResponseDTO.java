package org.example.cineapi.dto;

public record DiretorResponseDTO(
        Long id,
        String nome,
        String nacionalidade,
        Integer idade,
        String biografia
) {}
