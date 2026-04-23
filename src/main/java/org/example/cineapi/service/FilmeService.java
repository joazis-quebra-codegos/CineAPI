package org.example.cineapi.service;

import org.example.cineapi.dto.FilmeRequestDTO;
import org.example.cineapi.dto.FilmeResponseDTO;
import org.example.cineapi.model.Filme;
import org.example.cineapi.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {
    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository){
        this.repository = repository;
    }

    public FilmeResponseDTO salvar(FilmeRequestDTO dto){
        Filme filme = toEntity(dto);
        Filme salvo = repository.save(filme);
        return toResponseDTO(salvo);
    }

    public FilmeResponseDTO buscarPorId(Long idFilme){
        Filme filme = repository.findById(idFilme).orElseThrow(() -> new RuntimeException(""));
        return toResponseDTO(filme);
    }

    public List<FilmeResponseDTO> listar(){
        return repository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public void deletar(Long idFilme){
        Filme filme = repository.findById(idFilme).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        repository.delete(filme);
    }

    public FilmeResponseDTO atualizar(Long idFilme, FilmeRequestDTO dto){
        Filme existente = repository.findById(idFilme).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        existente.setTitulo(dto.titulo());
        existente.setGenero(dto.genero());
        existente.setDiretor(dto.diretor());
        existente.setAno(dto.ano());
        existente.setDuracao(dto.duracao());
        existente.setNota(dto.nota());

        Filme atualizado = repository.save(existente);
        return toResponseDTO(atualizado);

    }

    private Filme toEntity(FilmeRequestDTO dto){
        Filme filme = new Filme();
        filme.setTitulo(dto.titulo());
        filme.setGenero(dto.genero());
        filme.setDiretor(dto.diretor());
        filme.setAno(dto.ano());
        filme.setDuracao(dto.duracao());
        filme.setNota(dto.nota());
        return filme;
    }

    private FilmeResponseDTO toResponseDTO(Filme filme){
        return new FilmeResponseDTO(
                filme.getIdFilme(),
                filme.getTitulo(),
                filme.getDiretor(),
                filme.getNota());
    }
}
