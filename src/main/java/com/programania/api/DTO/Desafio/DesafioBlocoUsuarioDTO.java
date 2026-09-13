package com.programania.api.DTO.Desafio;

import com.programania.api.Models.Desafio.DesafioBlocoUsuario;

import java.sql.Timestamp;
import java.util.UUID;

public record DesafioBlocoUsuarioDTO(
    UUID uuid,
    Long desafioBlocoId,
    Long usuarioId,
    Timestamp created_at,
    Timestamp updated_at
) {
    public DesafioBlocoUsuarioDTO(DesafioBlocoUsuario desafioBlocoUsuario){
        this(
            desafioBlocoUsuario.getUuid(),
            desafioBlocoUsuario.getDesafioBloco() != null ? desafioBlocoUsuario.getDesafioBloco().getId() : null,
            desafioBlocoUsuario.getUsuario() != null ? desafioBlocoUsuario.getUsuario().getId() : null,
            desafioBlocoUsuario.getCreated_at(),
            desafioBlocoUsuario.getUpdated_at()
        );
    }
}
