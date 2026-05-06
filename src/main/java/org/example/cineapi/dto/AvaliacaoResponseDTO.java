package org.example.cineapi.dto;

public record AvaliacaoResponseDTO (
        Long id,
        Integer nota,
        String comentario,
        Long idFilme
){}
