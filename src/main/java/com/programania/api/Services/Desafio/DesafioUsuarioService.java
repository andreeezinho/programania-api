package com.programania.api.Services.Desafio;

import com.programania.api.DTO.Desafio.DesafioUsuarioDTO;
import com.programania.api.DTO.Usuario.UsuarioDTO;
import com.programania.api.DTO.Usuario.UsuarioPasswordDTO;
import com.programania.api.Models.Desafio.DesafioUsuario;
import com.programania.api.Models.Usuario.Usuario;
import com.programania.api.Repositories.Desafio.DesafioUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DesafioUsuarioService {

    @Autowired
    DesafioUsuarioRepository desafioUsuarioRepository;

    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.desafioUsuarioRepository
                .findAll()
                .stream()
                .map(DesafioUsuarioDTO::new)
                .toList());
    }

    public ResponseEntity<?> findByUuid(UUID uuid){
        return this.desafioUsuarioRepository
                .findByUuid(uuid)
                .map(record -> ResponseEntity.ok().body(new DesafioUsuarioDTO(record)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> create(DesafioUsuario desafioUsuario) {
        return ResponseEntity.ok(new DesafioUsuarioDTO(
                this.desafioUsuarioRepository.save(desafioUsuario)
        ));
    }

    public ResponseEntity<?> update(UUID uuid, DesafioUsuario desafioUsuario) {
        return this.desafioUsuarioRepository
                .findByUuid(uuid)
                .map(record -> {
                    record.setCompleta(desafioUsuario.getCompleta());

                    DesafioUsuario update  = this.desafioUsuarioRepository.save(record);
                    return ResponseEntity.ok().body(new DesafioUsuarioDTO(update));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> delete(UUID uuid) {
        DesafioUsuario desafioUsuario = desafioUsuarioRepository
                .findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Desafio não encontrado"));

        this.desafioUsuarioRepository.delete(desafioUsuario);

        return ResponseEntity.ok("Desafio do usuário deletado");
    }

}
