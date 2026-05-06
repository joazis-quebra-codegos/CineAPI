package org.example.cineapi.dto;

public record FilmeResponseDTO(
        Long idFilme,
        String titulo,
        Long idDiretor,
        String nome,
        Double mediaAvaliacao
) {}
