package com.programania.api.DTO.Fase;

import java.sql.Timestamp;
import java.util.UUID;

import com.programania.api.Models.Fase.Fase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaseDTO {

    private Long id;
    private UUID uuid;
    private Integer numero;
    private String nome;
    private Boolean ativo;
    private Timestamp created_at;
    private Timestamp updated_at;

    public FaseDTO(Fase fase) {
        this(
            fase.getId(),
            fase.getUuid(),
            fase.getNumero(),
            fase.getNome(),
            fase.getAtivo(),
            fase.getCreated_at(),
            fase.getUpdated_at()
        );
    }
}