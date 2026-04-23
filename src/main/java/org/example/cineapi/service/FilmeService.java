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

    public Filme buscarPorId(Long idFilme){
        return repository.findById(idFilme).orElseThrow(() -> new RuntimeException(""));
    }

    public List<Filme> listar(){
        return repository.findAll();
    }

    public void deletar(Long idFilme){
        repository.deleteById(idFilme);
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
