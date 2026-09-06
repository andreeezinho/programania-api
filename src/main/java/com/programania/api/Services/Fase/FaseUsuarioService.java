package com.programania.api.Services.Fase;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.programania.api.DTO.Fase.FaseUsuarioDTO;
import com.programania.api.Models.Fase.FaseUsuario;
import com.programania.api.Repositories.Fase.FaseUsuarioRepository;
import com.programania.api.Repositories.Fase.FaseRepository;
import com.programania.api.Repositories.Usuario.UsuarioRepository;

@Service
public class FaseUsuarioService {

    private final FaseUsuarioRepository faseUsuarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final FaseRepository faseRepository;

    public FaseUsuarioService(FaseUsuarioRepository faseUsuarioRepository, UsuarioRepository usuarioRepository,
                              FaseRepository faseRepository) {

        this.faseUsuarioRepository = faseUsuarioRepository;
        this.usuarioRepository = usuarioRepository;
        this.faseRepository = faseRepository;
    }

    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(this.faseUsuarioRepository.findAll().stream().map(FaseUsuarioDTO::new).toList());
    }

    public ResponseEntity<?> findByUuid(UUID uuid) {

        return this.faseUsuarioRepository.findByUuid(uuid).map(record -> ResponseEntity.ok()
                .body(new FaseUsuarioDTO(record))).orElse(ResponseEntity.notFound().build());
    }
}