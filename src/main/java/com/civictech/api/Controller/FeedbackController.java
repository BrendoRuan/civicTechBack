package com.civictech.api.Controller;

import com.civictech.api.Entity.Feedback;
import com.civictech.api.Repository.FeedbackRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
@CrossOrigin("*")
public class FeedbackController {

    private final FeedbackRepository repository;

    public FeedbackController(
            FeedbackRepository repository
    ) {
        this.repository = repository;
    }

    @GetMapping
    public List<Feedback> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Feedback criar(
            @RequestBody Feedback feedback
    ) {
        return repository.save(feedback);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}