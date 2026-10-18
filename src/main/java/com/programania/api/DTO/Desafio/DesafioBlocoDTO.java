package com.programania.api.DTO.Desafio;

import com.programania.api.DTO.Bloco.BlocoDTO;
import com.programania.api.Models.Desafio.DesafioBloco;

import java.sql.Timestamp;
import java.util.UUID;

public record DesafioBlocoDTO(
    UUID uuid,
    Integer ordem,
    Long desafioId,
    BlocoDTO bloco,
    Timestamp created_at,
    Timestamp updated_at
) {
    public DesafioBlocoDTO(DesafioBloco desafioBloco){
        this(
            desafioBloco.getUuid(),
            desafioBloco.getOrdem(),
            desafioBloco.getDesafio() != null ? desafioBloco.getDesafio().getId() : null,
            desafioBloco.getBloco() != null ? new BlocoDTO(desafioBloco.getBloco()) : null,
            desafioBloco.getCreated_at(),
            desafioBloco.getUpdated_at()
        );
    }
}
