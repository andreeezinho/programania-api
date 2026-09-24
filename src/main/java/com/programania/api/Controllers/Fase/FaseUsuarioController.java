package com.programania.api.Controllers.Fase;

import java.util.UUID;

import com.programania.api.Models.Fase.FaseUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programania.api.Services.Fase.FaseUsuarioService;

@RestController
@RequestMapping("/phase-users")
public class FaseUsuarioController {

    private final FaseUsuarioService faseUsuarioService;

    public FaseUsuarioController(FaseUsuarioService faseUsuarioService) {
        this.faseUsuarioService = faseUsuarioService;
    }

    @GetMapping
    public ResponseEntity<?> index() {

        return this.faseUsuarioService.findAll();

    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> findByUuid(@PathVariable UUID uuid) {

        return this.faseUsuarioService.findByUuid(uuid);

    }
}