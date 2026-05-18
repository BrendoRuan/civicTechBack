package com.civictech.api.Service;

import com.civictech.api.Entity.Feedback;
import com.civictech.api.Repository.FeedbackRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepository repository;

    public FeedbackService(
            FeedbackRepository repository
    ) {
        this.repository = repository;
    }

    // LISTAR
    public List<Feedback> listar() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    public Feedback buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Feedback não encontrado"));
    }

    // CRIAR
    public Feedback criar(Feedback feedback) {
        return repository.save(feedback);
    }

    // ATUALIZAR
    public Feedback atualizar(
            Long id,
            Feedback dados
    ) {

        Feedback feedback = buscarPorId(id);

        feedback.setNomeUsuario(dados.getNomeUsuario());
        feedback.setComentario(dados.getComentario());
        feedback.setNota(dados.getNota());

        return repository.save(feedback);
    }

    // DELETAR
    public void deletar(Long id) {

        Feedback feedback = buscarPorId(id);

        repository.delete(feedback);
    }
}