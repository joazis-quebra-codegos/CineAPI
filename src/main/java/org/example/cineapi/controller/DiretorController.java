package org.example.cineapi.controller;

import jakarta.validation.Valid;
import org.example.cineapi.dto.DiretorRequestDTO;
import org.example.cineapi.dto.DiretorResponseDTO;
import org.example.cineapi.repository.DiretorRepository;
import org.example.cineapi.service.DiretorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private final DiretorService service;

    public DiretorController(DiretorService service){
        this.service = service;
    }

    @GetMapping
    public List<DiretorResponseDTO> listar(){
        return service.listar();
    }

    @GetMapping("/{idDiretor}")
    public DiretorResponseDTO buscarPorId(@PathVariable Long idDiretor){
        return service.buscarPorId(idDiretor);
    }

    @PostMapping
    public DiretorResponseDTO salvar(@RequestBody @Valid DiretorRequestDTO dto){
        return service.salvar(dto);
    }

    @DeleteMapping("/{idDiretor}")
    public void deletar(@PathVariable Long idFilme){

    }



}
