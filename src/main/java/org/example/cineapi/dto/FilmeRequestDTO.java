package org.example.cineapi.dto;

public record FilmeRequestDTO(
        String titulo,
        String genero,
        String diretor,
        Integer ano,
        Integer duracao,
        Integer nota
) {}
