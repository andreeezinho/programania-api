package com.programania.api.DTO.Desafio;

import com.programania.api.Models.Desafio.DesafioUsuario;

import java.sql.Timestamp;
import java.util.UUID;

public record DesafioUsuarioDTO (
    UUID uuid,
    String nome,
    Boolean completa,
    Long desafaioId,
    Long faseId,
    Timestamp created_at,
    Timestamp updated_at
){
    public DesafioUsuarioDTO(DesafioUsuario desafioUsuario){
        this(
            desafioUsuario.getUuid(),
            desafioUsuario.getNome(),
            desafioUsuario.getCompleta(),
            desafioUsuario.getDesafio() != null ? desafioUsuario.getDesafio().getId() : null,
            desafioUsuario.getUsuario() != null ? desafioUsuario.getUsuario().getId() : null,
            desafioUsuario.getCreated_at(),
            desafioUsuario.getUpdated_at()
        );
    }
}
