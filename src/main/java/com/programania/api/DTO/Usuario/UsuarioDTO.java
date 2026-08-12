package com.programania.api.DTO.Usuario;

import com.programania.api.Models.Usuario.Usuario;
import com.programania.api.Models.Usuario.UsuarioRole;

import java.sql.Timestamp;
import java.util.UUID;

public record UsuarioDTO(
        UUID uuid,
        String login,
        String nome,
        String email,
        UsuarioRole role,
        String icone,
        Boolean ativo,
        Timestamp created_at,
        Timestamp updated_at
){
    public UsuarioDTO(Usuario usuario){
        this(
                usuario.getUuid(),
                usuario.getLogin(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole(),
                usuario.getIcone(),
                usuario.getAtivo(),
                usuario.getCreated_at(),
                usuario.getUpdated_at()
        );
    }
}
