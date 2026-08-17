package com.programania.api.DTO.Desafio;

import com.programania.api.Models.Desafio.Desafio;

import java.time.Instant;
import java.util.UUID;

public record DesafioDTO(
        UUID uuid,
        String nome,
        String descricao,
        String dicas,
        int faseId,
        Boolean ativo,
        Instant createdAt,
        Instant updatedAt
) {
    public DesafioDTO(Desafio desafio) {
        this(
                desafio.getUuid(),
                desafio.getNome(),
                desafio.getDescricao(),
                desafio.getDicas(),
                desafio.getFaseId(),
                desafio.getAtivo(),
                desafio.getCreatedAt(),
                desafio.getUpdatedAt()
        );
    }
}