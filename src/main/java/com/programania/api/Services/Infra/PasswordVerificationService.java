package com.programania.api.Services.Infra;

import com.programania.api.DTO.Usuario.UsuarioPasswordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordVerificationService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Boolean verify(String userPassword, UsuarioPasswordDTO password){
        Boolean oldPasswordMatches = passwordEncoder.matches(password.senhaAntiga(), userPassword);
        Boolean newPasswordMatches = password.novaSenha().equals(password.confirmacaoSenha());

        return oldPasswordMatches && newPasswordMatches;
    }
}