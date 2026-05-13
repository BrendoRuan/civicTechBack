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

    @GetMapping
    public List<Ocorrencia> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Ocorrencia criar(@RequestBody Ocorrencia ocorrencia) {
        ocorrencia.setStatus("ABERTO");
        return repository.save(ocorrencia);
    }
}
