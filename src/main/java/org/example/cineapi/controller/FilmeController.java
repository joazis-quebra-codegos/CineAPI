package org.example.cineapi.controller;

import jakarta.validation.Valid;
import org.example.cineapi.dto.FilmeRequestDTO;
import org.example.cineapi.dto.FilmeResponseDTO;
import org.example.cineapi.model.Filme;
import org.example.cineapi.service.FilmeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService service;

    public FilmeController(FilmeService service){
        this.service = service;
    }

    @GetMapping
    public List<Filme> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Filme buscarPorId(@PathVariable Long idFilme){
        return service.buscarPorId(idFilme);
    }

    @PostMapping
    public FilmeResponseDTO salvar(@RequestBody @Valid FilmeRequestDTO filme){
        return service.salvar(filme);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long idFilme){
        service.deletar(idFilme);
    }
}
