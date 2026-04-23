package org.example.cineapi.dto;

public record FilmeResponseDTO(
        Long idFilme,
        String titulo,
        String diretor,
        Integer nota
) {}
