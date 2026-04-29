package org.example.cineapi.service;

import org.example.cineapi.dto.DiretorRequestDTO;
import org.example.cineapi.dto.DiretorResponseDTO;
import org.example.cineapi.dto.FilmeResponseDTO;
import org.example.cineapi.model.Diretor;
import org.example.cineapi.model.Filme;
import org.example.cineapi.repository.DiretorRepository;
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

    public DiretorResponseDTO buscarPorId(Long idDiretor){
        Diretor diretor = repository.findById(idDiretor).
            orElseThrow(() -> new RuntimeException("Diretor não existe"));

        return toResponseDTO(diretor);
    }

    public Diretor buscarEntidade(Long idDiretor){
        return repository.findById(idDiretor).
            orElseThrow(() -> new RuntimeException("Diretor não encontrado"));
    }

    private DiretorResponseDTO toResponseDTO(Diretor diretor){
        return new DiretorResponseDTO(
                diretor.getIdDiretor(),
                diretor.getNome(),
                diretor.getNacionalidade(),
                diretor.getIdade(),
                diretor.getBiografia()
        );
    }
}
