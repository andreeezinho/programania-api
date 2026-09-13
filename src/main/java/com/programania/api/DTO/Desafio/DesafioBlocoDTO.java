package com.programania.api.DTO.Desafio;

import com.programania.api.Models.Desafio.DesafioBloco;

import java.sql.Timestamp;
import java.util.UUID;

public record DesafioBlocoDTO(
    UUID uuid,
    Integer ordem,
    Long desafaioId,
    Long blocoId,
    Timestamp created_at,
    Timestamp updated_at
) {
    public DesafioBlocoDTO(DesafioBloco desafioBloco){
        this(
            desafioBloco.getUuid(),
            desafioBloco.getOrdem(),
            desafioBloco.getDesafio() != null ? desafioBloco.getDesafio().getId() : null,
            desafioBloco.getBloco() != null ? desafioBloco.getBloco().getId() : null,
            desafioBloco.getCreated_at(),
            desafioBloco.getUpdated_at()
        );
    }
}
