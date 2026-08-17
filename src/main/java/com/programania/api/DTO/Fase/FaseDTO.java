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
        this.id = fase.getId();
        this.uuid = fase.getUuid();
        this.numero = fase.getNumero();
        this.nome = fase.getNome();
        this.ativo = fase.getAtivo();
        this.created_at = fase.getCreated_at();
        this.updated_at = fase.getUpdated_at();
    }
}