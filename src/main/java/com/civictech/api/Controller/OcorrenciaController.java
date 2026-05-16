package com.civictech.api.Controller;

import com.civictech.api.Entity.Ocorrencia;
import com.civictech.api.Enum.StatusOcorrencia;
import com.civictech.api.Service.OcorrenciaService;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ocorrencias")
@CrossOrigin("*")
public class OcorrenciaController {

    private final OcorrenciaService service;

    public OcorrenciaController(
            OcorrenciaService service
    ) {
        this.service = service;
    }

    // LISTAR
    @GetMapping("/listar")
    public List<Ocorrencia> listar() {
        return service.listar();
    }

    // BUSCAR POR ID
    @GetMapping("/buscarID/{id}")
    public Ocorrencia buscarPorId(
            @PathVariable Long id
    ) {
        return service.buscarPorId(id);
    }

    // BUSCAR POR TITULO
    @GetMapping("/buscar")
    public List<Ocorrencia> buscarPorTitulo(
            @RequestParam String titulo
    ) {
        return service.buscarPorTitulo(titulo);
    }

    // CRIAR
    @PostMapping("/criar")
    public Ocorrencia criar(
            @RequestBody Ocorrencia ocorrencia
    ) {
        return service.criar(ocorrencia);
    }
    @PostMapping("/upload/imagem")
    public ResponseEntity<String> uploadImagem(
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        String nomeArquivo =
                UUID.randomUUID() + "_" + file.getOriginalFilename();

        File destino = new File(
                "uploads/imagens/" + nomeArquivo
        );

        file.transferTo(destino);

        String url =
                "https://civictechback.onrender.com/uploads/imagens/" + nomeArquivo;

        return ResponseEntity.ok(url);
    }
    @PostMapping("/upload/video")
    public ResponseEntity<String> uploadVideo(
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        String nomeArquivo =
                UUID.randomUUID() + "_" + file.getOriginalFilename();

        File destino = new File(
                "uploads/videos/" + nomeArquivo
        );

        file.transferTo(destino);

        String url =
                "https://civictechback.onrender.com/uploads/videos/" + nomeArquivo;

        return ResponseEntity.ok(url);
    }

    // ATUALIZAR
    @PutMapping("/atualizar/{id}")
    public Ocorrencia atualizar(
            @PathVariable Long id,
            @RequestBody Ocorrencia ocorrencia
    ) {
        return service.atualizar(id, ocorrencia);
    }

    // ALTERAR STATUS
    @PatchMapping("/{id}/status")
    public Ocorrencia alterarStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> body
    ) {

        StatusOcorrencia status =
                StatusOcorrencia.valueOf(body.get("status"));

        return service.alterarStatus(id, status);
    }

    // DELETAR
    @DeleteMapping("/deletar/{id}")
    public void deletar(
            @PathVariable Long id
    ) {
        service.deletar(id);
    }
}