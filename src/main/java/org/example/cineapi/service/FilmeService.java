package org.example.cineapi.service;

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

    public Filme salvar(Filme filme){
        return repository.save(filme);
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
}
