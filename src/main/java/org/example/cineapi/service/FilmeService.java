package org.example.cineapi.service;

import org.example.cineapi.dto.FilmeRequestDTO;
import org.example.cineapi.dto.FilmeResponseDTO;
import org.example.cineapi.model.Diretor;
import org.example.cineapi.model.Filme;
import org.example.cineapi.repository.DiretorRepository;
import org.example.cineapi.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {
    private final FilmeRepository repository;
    private final DiretorService diretorService;

    public FilmeService(FilmeRepository repository, DiretorService diretorService){
        this.repository = repository;
        this.diretorService = diretorService;
    }

    public FilmeResponseDTO salvar(FilmeRequestDTO dto){
        Filme filme = toEntity(dto);
        Filme salvo = repository.save(filme);
        return toResponseDTO(salvo);
    }

    public FilmeResponseDTO buscarPorId(Long id){
        Filme filme = repository.findById(id).orElseThrow(() -> new RuntimeException(""));
        return toResponseDTO(filme);
    }

    public List<FilmeResponseDTO> buscarDiretorFilmes(Long id){
        diretorService.buscarEntidade(id);
        return repository.findByDiretorId(id)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public List<FilmeResponseDTO> listar(){
        return repository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public void deletar(Long id){
        Filme filme = repository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        repository.delete(filme);
    }

    public FilmeResponseDTO atualizar(Long id, FilmeRequestDTO dto){
        Filme existente = repository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        Diretor diretor = diretorService.buscarEntidade(dto.idDiretor());
        existente.setTitulo(dto.titulo());
        existente.setGenero(dto.genero());
        existente.setDiretor(diretor);
        existente.setAno(dto.ano());
        existente.setDuracao(dto.duracao());
        existente.setNota(dto.nota());

        Filme atualizado = repository.save(existente);
        return toResponseDTO(atualizado);

    }

    private Filme toEntity(FilmeRequestDTO dto){
        Diretor diretor = diretorService.buscarEntidade(dto.idDiretor());
        Filme filme = new Filme();
        filme.setTitulo(dto.titulo());
        filme.setGenero(dto.genero());
        filme.setDiretor(diretor);
        filme.setAno(dto.ano());
        filme.setDuracao(dto.duracao());
        filme.setNota(dto.nota());
        return filme;
    }

    private FilmeResponseDTO toResponseDTO(Filme filme){
        return new FilmeResponseDTO(
                filme.getId(),
                filme.getTitulo(),
                filme.getDiretor().getId(),
                filme.getDiretor().getNome(),
                filme.getNota()
        );
    }
}
