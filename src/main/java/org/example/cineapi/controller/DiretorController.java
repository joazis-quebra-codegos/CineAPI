package org.example.cineapi.controller;

import jakarta.validation.Path;
import jakarta.validation.Valid;
import org.example.cineapi.dto.DiretorRequestDTO;
import org.example.cineapi.dto.DiretorResponseDTO;
import org.example.cineapi.dto.FilmeResponseDTO;
import org.example.cineapi.model.Filme;
import org.example.cineapi.repository.DiretorRepository;
import org.example.cineapi.service.DiretorService;
import org.example.cineapi.service.FilmeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private final DiretorService service;
    private final FilmeService filmeService;

    public DiretorController(DiretorService service, FilmeService filmeService){
        this.service = service;
        this.filmeService = filmeService;
    }

    @GetMapping
    public List<DiretorResponseDTO> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public DiretorResponseDTO buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @GetMapping("/{id}/filmes")
    public List<FilmeResponseDTO> buscarDiretorFilmes(@PathVariable Long id){
        return filmeService.buscarDiretorFilmes(id);
    }

    @PostMapping
    public DiretorResponseDTO salvar(@RequestBody @Valid DiretorRequestDTO dto){
        return service.salvar(dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

    @PutMapping("/{id}")
    public DiretorResponseDTO atualizar(@RequestBody @Valid DiretorRequestDTO dto, @PathVariable Long id){
        return service.atualizar(id, dto);
    }



}
