package com.civictech.api.Controller;

import com.civictech.api.Entity.Ocorrencia;
import com.civictech.api.Repository.OcorrenciaRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencias")
@CrossOrigin("*")
public class OcorrenciaController {

    private final OcorrenciaRepository repository;

    public OcorrenciaController(OcorrenciaRepository repository) {
        this.repository = repository;
    }

    // LISTAR TODAS
    @GetMapping
    public List<Ocorrencia> listar() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Ocorrencia buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    // BUSCAR POR TITULO
    @GetMapping("/buscar")
    public List<Ocorrencia> buscarPorTitulo(
            @RequestParam String titulo
    ) {
        return repository.findByTituloContainingIgnoreCase(titulo);
    }

    // CRIAR
    @PostMapping
    public Ocorrencia criar(
            @RequestBody Ocorrencia ocorrencia
    ) {
        return repository.save(ocorrencia);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public Ocorrencia atualizar(
            @PathVariable Long id,
            @RequestBody Ocorrencia dados
    ) {

        Ocorrencia ocorrencia = repository.findById(id)
                .orElseThrow();

        ocorrencia.setTitulo(dados.getTitulo());
        ocorrencia.setDescricao(dados.getDescricao());
        ocorrencia.setCategoria(dados.getCategoria());
        ocorrencia.setStatus(dados.getStatus());
        ocorrencia.setLatitude(dados.getLatitude());
        ocorrencia.setLongitude(dados.getLongitude());
        ocorrencia.setNomeUsuario(dados.getNomeUsuario());

        return repository.save(ocorrencia);
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}