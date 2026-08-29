package com.programania.api.DTO.Notificacao;

import com.programania.api.Models.Notificacao.Notificacao;

import java.sql.Timestamp;
import java.util.UUID;

public record NotificacaoDTO(
        UUID uuid,
        String titulo,
        String mensagem,
        Boolean lido,
        Long usuarioId,
        Boolean ativo,
        Timestamp created_at,
        Timestamp updated_at
) {
    public NotificacaoDTO(Notificacao notificacao) {
        this(
                notificacao.getUuid(),
                notificacao.getTitulo(),
                notificacao.getMensagem(),
                notificacao.getLido(),
                notificacao.getUsuario() != null ? notificacao.getUsuario().getId() : null,
                notificacao.getAtivo(),
                notificacao.getCreated_at(),
                notificacao.getUpdated_at()
        );
    }
}