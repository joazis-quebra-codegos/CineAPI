package org.example.cineapi.controller;

import jakarta.validation.Valid;
import org.example.cineapi.model.Filme;
import org.example.cineapi.service.FilmeService;
import org.springframework.stereotype.Controller;
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

    @GetMapping("{/id}")
    public Filme buscarPorId(@PathVariable Long idFilme){
        return service.buscarPorId(idFilme);
    }

    @PostMapping
    public Filme salvar(@RequestBody @Valid Filme filme){
        return service.salvar(filme);
    }
}
