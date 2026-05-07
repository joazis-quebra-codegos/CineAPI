package org.example.cineapi.controller;

import jakarta.validation.Valid;
import org.example.cineapi.dto.AvaliacaoResponseDTO;
import org.example.cineapi.dto.FilmeRequestDTO;
import org.example.cineapi.dto.FilmeResponseDTO;
import org.example.cineapi.model.Avaliacao;
import org.example.cineapi.model.Filme;
import org.example.cineapi.service.AvaliacaoService;
import org.example.cineapi.service.FilmeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService service;
    private final AvaliacaoService avaliacaoService;

    public FilmeController(FilmeService service, AvaliacaoService avaliacaoService){
        this.avaliacaoService = avaliacaoService;
        this.service = service;
    }

    @GetMapping
    public List<FilmeResponseDTO> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public FilmeResponseDTO buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public FilmeResponseDTO salvar(@RequestBody @Valid FilmeRequestDTO dto){
        return service.salvar(dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

    @PutMapping("/{id}")
    public FilmeResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid FilmeRequestDTO dto){
        return service.atualizar(id, dto);
    }

    @GetMapping("/{id}/avaliacoes")
    public List<AvaliacaoResponseDTO> listarAvaliacoesPorFilme(@PathVariable Long id){
        return avaliacaoService.listarPorFilme(id);
    }
}
