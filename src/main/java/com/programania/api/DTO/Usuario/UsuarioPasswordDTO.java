package com.programania.api.DTO.Usuario;

public record UsuarioPasswordDTO (
        String senhaAntiga,
        String novaSenha,
        String confirmacaoSenha
){}
