package com.civictech.api.Service;

import com.civictech.api.Entity.Ocorrencia;
import com.civictech.api.Enum.StatusOcorrencia;
import com.civictech.api.Repository.OcorrenciaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcorrenciaService {

    private final OcorrenciaRepository repository;

    public OcorrenciaService(
            OcorrenciaRepository repository
    ) {
        this.repository = repository;
    }

    // LISTAR
    public List<Ocorrencia> listar() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    public Ocorrencia buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Ocorrência não encontrada"));
    }

    // BUSCAR POR TITULO
    public List<Ocorrencia> buscarPorTitulo(String titulo) {
        return repository.findByTituloContainingIgnoreCase(titulo);
    }

    // CRIAR
    public Ocorrencia criar(Ocorrencia ocorrencia) {

        // GARANTE STATUS AUTOMÁTICO
        ocorrencia.setStatus(StatusOcorrencia.EM_ANALISE);

        return repository.save(ocorrencia);
    }

    // ATUALIZAR
    public Ocorrencia atualizar(
            Long id,
            Ocorrencia dados
    ) {

        Ocorrencia ocorrencia = buscarPorId(id);

        ocorrencia.setTitulo(dados.getTitulo());
        ocorrencia.setDescricao(dados.getDescricao());
        ocorrencia.setCategoria(dados.getCategoria());

        ocorrencia.setImagemUrl(dados.getImagemUrl());
        ocorrencia.setVideoUrl(dados.getVideoUrl());

        ocorrencia.setLatitude(dados.getLatitude());
        ocorrencia.setLongitude(dados.getLongitude());
        ocorrencia.setNomeUsuario(dados.getNomeUsuario());

        return repository.save(ocorrencia);
    }
    // ALTERAR STATUS
    public Ocorrencia alterarStatus(
            Long id,
            StatusOcorrencia status
    ) {

        Ocorrencia ocorrencia = buscarPorId(id);

        ocorrencia.setStatus(status);

        return repository.save(ocorrencia);
    }

    // DELETAR
    public void deletar(Long id) {

        Ocorrencia ocorrencia = buscarPorId(id);

        repository.delete(ocorrencia);
    }
}