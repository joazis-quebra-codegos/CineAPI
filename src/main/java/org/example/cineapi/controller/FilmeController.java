package org.example.cineapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Path;
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
@Tag(name = "Filmes", description = "Endpoints para gerenciamento e consulta de filmes")
public class FilmeController {

    private final FilmeService service;
    private final AvaliacaoService avaliacaoService;

    public FilmeController(FilmeService service, AvaliacaoService avaliacaoService){
        this.avaliacaoService = avaliacaoService;
        this.service = service;
    }

    @Operation(summary = "Listar filmes", description = "Retorna todos os filmes cadastrados")
    @GetMapping
    public List<FilmeResponseDTO> listar(){
        return service.listar();
    }

    @Operation(summary = "Buscar filme", description = "Buscar filme por Id")
    @GetMapping("/{id}")
    public FilmeResponseDTO buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @Operation(summary = "Salvar filmes", description = "Cadastra um filme novo")
    @PostMapping
    public FilmeResponseDTO salvar(@RequestBody @Valid FilmeRequestDTO dto){
        return service.salvar(dto);
    }

    @Operation(summary = "Deletar filmes", description = "Deleta um filme atravéz do Id")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

    @Operation(summary = "Atualizar filmes", description = "Atualiza um filme atravéz do Id")
    @PutMapping("/{id}")
    public FilmeResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid FilmeRequestDTO dto){
        return service.atualizar(id, dto);
    }

    @GetMapping("/{id}/avaliacoes")
    public List<AvaliacaoResponseDTO> listarAvaliacoesPorFilme(@PathVariable Long id){
        return avaliacaoService.listarPorFilme(id);
    }

    @GetMapping("/titulo")
    public List<FilmeResponseDTO> listarPorTitulo(@RequestParam String titulo){
        return service.buscarPorTitulo(titulo);
    }

    @GetMapping("/genero")
    public List<FilmeResponseDTO> listarPorGenero(@RequestParam String genero){
        return service.buscarPorGenero(genero);
    }
}
