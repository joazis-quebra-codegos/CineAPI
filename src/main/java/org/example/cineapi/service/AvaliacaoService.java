package org.example.cineapi.service;

import org.example.cineapi.dto.AvaliacaoRequestDTO;
import org.example.cineapi.dto.AvaliacaoResponseDTO;
import org.example.cineapi.dto.FilmeRequestDTO;
import org.example.cineapi.model.Avaliacao;
import org.example.cineapi.model.Diretor;
import org.example.cineapi.model.Filme;
import org.example.cineapi.repository.AvaliacaoRepository;
import org.example.cineapi.repository.FilmeRepository;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository repository;
    private final FilmeRepository filmeRepository;

    AvaliacaoService(AvaliacaoRepository repository, FilmeRepository filmeRepository){
        this.repository = repository;
        this.filmeRepository = filmeRepository;
    }

    public AvaliacaoResponseDTO salvar(AvaliacaoRequestDTO dto){
        Avaliacao avaliacao = toEntity(dto);
        return toResponse(avaliacao);
    }

    private Avaliacao toEntity(AvaliacaoRequestDTO dto){
        Filme filme = filmeRepository.findById(dto.idFilme())
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        Avaliacao avaliacao = new Avaliacao(
                dto.nota(),
                dto.comentario(),
                filme);
        return avaliacao;
    }

    private AvaliacaoResponseDTO toResponse(Avaliacao avaliacao){
        return new AvaliacaoResponseDTO(
                avaliacao.getId(),
                avaliacao.getNota(),
                avaliacao.getComentario(),
                avaliacao.getFilme().getId(),
                avaliacao.getFilme().getTitulo()
        );
    }
}
