package com.civictech.api.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "feedbacks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeUsuario;

    // PERGUNTAS
    private Integer pergunta1;
    private Integer pergunta2;
    private Integer pergunta3;
    private Integer pergunta4;
    private Integer pergunta5;
    private Integer pergunta6;
    private Integer pergunta7;
    private Integer pergunta8;
    private Integer pergunta9;
    private Integer pergunta10;

    // NOTA GERAL
    private Integer nota;

    // COMENTÁRIO
    @Column(columnDefinition = "TEXT")
    private String comentario;

    private LocalDateTime dataCriacao;

    @PrePersist
    public void prePersist() {

        dataCriacao = LocalDateTime.now();
    }
}