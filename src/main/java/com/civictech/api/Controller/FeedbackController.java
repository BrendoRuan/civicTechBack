package com.civictech.api.Controller;

import com.civictech.api.Entity.Feedback;
import com.civictech.api.Service.FeedbackService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
@CrossOrigin("*")
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(
            FeedbackService service
    ) {
        this.service = service;
    }

    // LISTAR
    @GetMapping("/listar")
    public List<Feedback> listar() {
        return service.listar();
    }

    // BUSCAR POR ID
    @GetMapping("/buscarID/{id}")
    public Feedback buscarPorId(
            @PathVariable Long id
    ) {
        return service.buscarPorId(id);
    }

    // CRIAR
    @PostMapping("/criar")
    public Feedback criar(
            @RequestBody Feedback feedback
    ) {
        return service.criar(feedback);
    }

    // ATUALIZAR
    @PutMapping("/atualizar/{id}")
    public Feedback atualizar(
            @PathVariable Long id,
            @RequestBody Feedback feedback
    ) {
        return service.atualizar(id, feedback);
    }

    // DELETAR
    @DeleteMapping("/deletar/{id}")
    public void deletar(
            @PathVariable Long id
    ) {
        service.deletar(id);
    }
}