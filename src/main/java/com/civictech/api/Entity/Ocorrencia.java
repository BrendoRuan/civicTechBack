package com.civictech.api.Entity;
import com.civictech.api.Enum.StatusOcorrencia;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ocorrencias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private String categoria;

    @Enumerated(EnumType.STRING)
    private StatusOcorrencia status;

    private Double latitude;

    private Double longitude;

    private String nomeUsuario;

    // NOVOS CAMPOS
    private String imagemUrl;

    private String videoUrl;

    private LocalDateTime dataCriacao;

    @PrePersist
    public void prePersist() {

        dataCriacao = LocalDateTime.now();

        if (status == null) {
            status = StatusOcorrencia.EM_ANALISE;
        }
    }
}