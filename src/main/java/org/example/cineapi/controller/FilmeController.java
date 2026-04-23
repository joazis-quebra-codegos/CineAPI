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
    public List<FilmeResponseDTO> listar(){
        return service.listar();
    }

    @GetMapping("/{idFilme}")
    public FilmeResponseDTO buscarPorId(@PathVariable Long idFilme){
        return service.buscarPorId(idFilme);
    }

    @PostMapping
    public FilmeResponseDTO salvar(@RequestBody @Valid FilmeRequestDTO dto){
        return service.salvar(dto);
    }

    @DeleteMapping("/{idFilme}")
    public void deletar(@PathVariable Long idFilme){
        service.deletar(idFilme);
    }

    @PutMapping("/{idFilme}")
    public FilmeResponseDTO atualizar(@PathVariable Long idFilme, @RequestBody @Valid FilmeRequestDTO dto){
        return service.atualizar(idFilme, dto);
    }
}
