package org.example.cineapi.service;

import org.example.cineapi.dto.DiretorRequestDTO;
import org.example.cineapi.dto.DiretorResponseDTO;
import org.example.cineapi.dto.FilmeResponseDTO;
import org.example.cineapi.exception.RecursoNaoEncontradoException;
import org.example.cineapi.exception.RegraDeNegocioException;
import org.example.cineapi.model.Diretor;
import org.example.cineapi.model.Filme;
import org.example.cineapi.repository.DiretorRepository;
import org.example.cineapi.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiretorService {
    private final DiretorRepository repository;

    public DiretorService(DiretorRepository repository){
        this.repository = repository;
    }

    public DiretorResponseDTO salvar(DiretorRequestDTO dto){
        Diretor diretor = new Diretor();
        diretor.setNome(dto.nome());
        diretor.setNacionalidade(dto.nacionalidade());
        diretor.setIdade(dto.idade());
        diretor.setBiografia(dto.biografia());

        Diretor salvo = repository.save(diretor);
        return toResponseDTO(salvo);
    }

    public List<DiretorResponseDTO> listar(){
        return repository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public DiretorResponseDTO buscarPorId(Long id){
        Diretor diretor = repository.findById(id).
            orElseThrow(() -> new RecursoNaoEncontradoException("Diretor não encontrado"));

        return toResponseDTO(diretor);
    }

    public DiretorResponseDTO atualizar(Long id, DiretorRequestDTO dto){
        Diretor diretor = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Diretor não encontrado"));

        diretor.setNome(dto.nome());
        diretor.setNacionalidade(dto.nacionalidade());
        diretor.setIdade(dto.idade());
        diretor.setBiografia(dto.biografia());

        Diretor atualizado = repository.save(diretor);
        return toResponseDTO(atualizado);
    }

    public void deletar(Long id){
        Diretor diretor = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Diretor não encontrado"));

        if(!diretor.getFilmes().isEmpty()){
            throw new RegraDeNegocioException("Impossível deletar um diretor que possui filmes");
        }

        repository.delete(diretor);
    }

    public Diretor buscarEntidade(Long id){
        return repository.findById(id).
            orElseThrow(() -> new RecursoNaoEncontradoException("Diretor não encontrado"));
    }

    private DiretorResponseDTO toResponseDTO(Diretor diretor){
        return new DiretorResponseDTO(
                diretor.getId(),
                diretor.getNome(),
                diretor.getNacionalidade(),
                diretor.getIdade(),
                diretor.getBiografia()
        );
    }

}
