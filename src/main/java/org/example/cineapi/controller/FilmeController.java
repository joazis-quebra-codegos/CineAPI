package org.example.cineapi.controller;

import jakarta.validation.Valid;
import org.example.cineapi.model.Filme;
import org.example.cineapi.service.FilmeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class FilmeController {

    private final FilmeService service;

    public FilmeController(FilmeService service){
        this.service = service;
    }

    @GetMapping
    public List<Filme> listar(){
        return service.listar();
    }

    @PostMapping
    public Filme salvar(@RequestBody @Valid Filme filme){
        return service.salvar(filme);
    }
}
