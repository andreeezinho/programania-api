package com.programania.api.DTO.Desafio;

import com.programania.api.Models.Desafio.Desafio;

import java.util.UUID;

public record DesafioDTO(
        UUID uuid,
        String nome,
        String descricao,
        String dicas,
        int fase_id,
        Boolean ativo,
        Timestamp created_at,
        Timestamp updated_at
){
    public DesafioDTO(Desafio desafio) {
        this(
                desafio.getUuid(),
                desafio.getNome(),
                desafio.getDescricao(),
                desafio.getDicas(),
                desafio.getFase_id(),
                desafio.getAtivo(),
                desafio.getCreated_at(),
                desafio.getUpdated_at()
        );
    }
}
