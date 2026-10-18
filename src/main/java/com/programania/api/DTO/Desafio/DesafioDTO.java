package com.programania.api.DTO.Desafio;

import com.programania.api.Models.Desafio.Desafio;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

public record DesafioDTO(
        UUID uuid,
        String nome,
        int numero,
        String descricao,
        String dicas,
        int faseId,
        int startCell,
        int finishCell,
        Boolean ativo,
        Timestamp created_at,
        Timestamp updated_at
) {
    public DesafioDTO(Desafio desafio) {
        this(
                desafio.getUuid(),
                desafio.getNome(),
                desafio.getNumero(),
                desafio.getDescricao(),
                desafio.getDicas(),
                desafio.getFaseId(),
                desafio.getStart_cell(),
                desafio.getFinish_cell(),
                desafio.getAtivo(),
                desafio.getCreated_at(),
                desafio.getUpdated_at()
        );
    }
}