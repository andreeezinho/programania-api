package com.programania.api.DTO.Bloco;

import com.programania.api.Models.Bloco.Bloco;

import java.sql.Timestamp;
import java.util.UUID;

public record BlocoDTO(
    UUID uuid,
    String codigo,
    String tipo,
    Boolean ativo,
    Timestamp created_at,
    Timestamp updated_at
) {
    public BlocoDTO(Bloco bloco){
        this(
                bloco.getUuid(),
                bloco.getCodigo(),
                bloco.getTipo(),
                bloco.getAtivo(),
                bloco.getUpdated_at(),
                bloco.getCreated_at()
        );
    }
}
