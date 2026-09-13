package com.programania.api.Services.Desafio;

import com.programania.api.DTO.Desafio.DesafioBlocoDTO;
import com.programania.api.DTO.Desafio.DesafioBlocoUsuarioDTO;
import com.programania.api.Models.Desafio.DesafioBloco;
import com.programania.api.Models.Desafio.DesafioBlocoUsuario;
import com.programania.api.Repositories.Desafio.DesafioBlocoUsuarioRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
public class DesafioBlocoUsuarioService {

    @Autowired
    DesafioBlocoUsuarioRepository desafioBlocoUsuarioRepository;

    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.desafioBlocoUsuarioRepository
                .findAll()
                .stream()
                .map(DesafioBlocoUsuarioDTO::new)
                .toList());
    }

    public ResponseEntity<?> findByUuid(UUID uuid){
        return this.desafioBlocoUsuarioRepository
                .findByUuid(uuid)
                .map(record -> ResponseEntity.ok().body(new DesafioBlocoUsuarioDTO(record)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> create(DesafioBlocoUsuario desafioBlocoUsuario) {
        return ResponseEntity.ok(new DesafioBlocoUsuarioDTO(
                this.desafioBlocoUsuarioRepository.save(desafioBlocoUsuario)
        ));
    }

    public ResponseEntity<?> delete(UUID uuid) {
        DesafioBlocoUsuario desafioBlocoUsuario = desafioBlocoUsuarioRepository
                .findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Bloco do usuário no Desafio não encontrado"));

        this.desafioBlocoUsuarioRepository.delete(desafioBlocoUsuario);

        return ResponseEntity.ok("Bloco do usuário no desafio deletado");
    }

}
