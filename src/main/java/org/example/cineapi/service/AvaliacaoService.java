package org.example.cineapi.service;

import org.example.cineapi.dto.AvaliacaoRequestDTO;
import org.example.cineapi.dto.AvaliacaoResponseDTO;
import org.example.cineapi.dto.FilmeRequestDTO;
import org.example.cineapi.model.Avaliacao;
import org.example.cineapi.model.Diretor;
import org.example.cineapi.model.Filme;
import org.example.cineapi.repository.AvaliacaoRepository;

public class AvaliacaoService {

    private final AvaliacaoRepository repository;
    private final FilmeService filmeService;

    AvaliacaoService(AvaliacaoRepository repository, FilmeService filmeService){
        this.repository = repository;
        this.filmeService = filmeService;
    }

    public AvaliacaoResponseDTO salvar(AvaliacaoRequestDTO dto){
        Avaliacao avaliacao = toEntity(dto);
    }

    private Avaliacao toEntity(AvaliacaoRequestDTO dto){
        Filme Filme = filmeService.buscarEntidade(dto.idFilme());
        Avaliacao avaliacao = new Avaliacao();
        return avaliacao;
    }

    private AvaliacaoResponseDTO toResponse(Avaliacao avaliacao){
        return new AvaliacaoResponseDTO(
                avaliacao.getId(),
                avaliacao.getNota(),
                avaliacao.getComentario(),
                avaliacao.getFilme().getId()
        );
    }
}
