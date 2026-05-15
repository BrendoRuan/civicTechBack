package com.civictech.api.Repository;

import com.civictech.api.Entity.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OcorrenciaRepository
        extends JpaRepository<Ocorrencia, Long> {

    List<Ocorrencia> findByTituloContainingIgnoreCase(String titulo);

}