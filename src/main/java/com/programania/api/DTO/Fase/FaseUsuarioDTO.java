package com.programania.api.DTO.Fase;

import java.sql.Timestamp;
import java.util.UUID;

import com.programania.api.Models.Fase.FaseUsuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaseUsuarioDTO {

    private Long id;
    private UUID uuid;
    private UUID usuario_uuid;
    private UUID fase_uuid;
    private Timestamp created_at;
    private Timestamp updated_at;

    public FaseUsuarioDTO(FaseUsuario faseUsuario) {

        this.id = faseUsuario.getId();
        this.uuid = faseUsuario.getUuid();

        if (faseUsuario.getUsuario() != null) {
            this.usuario_uuid = faseUsuario.getUsuario().getUuid();
        }

        if (faseUsuario.getFase() != null) {
            this.fase_uuid = faseUsuario.getFase().getUuid();
        }

        this.created_at = faseUsuario.getCreated_at();
        this.updated_at = faseUsuario.getUpdated_at();
    }
}