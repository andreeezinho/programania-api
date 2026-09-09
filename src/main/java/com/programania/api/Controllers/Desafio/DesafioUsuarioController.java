package com.programania.api.Controllers.Desafio;

import com.programania.api.Models.Desafio.DesafioUsuario;
import com.programania.api.Services.Desafio.DesafioUsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RestController("/desafio-usuario")
public class DesafioUsuarioController {

    @Autowired
    DesafioUsuarioService desafioUsuarioService;

    @GetMapping
    public ResponseEntity<?> index() {
        return desafioUsuarioService.findAll();
    }

    @GetMapping(path = {"/{uuid}"})
    public ResponseEntity<?> findByUuid(@PathVariable UUID uuid){
        return this.desafioUsuarioService.findByUuid(uuid);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody DesafioUsuario desafioUsuario) {
        return this.desafioUsuarioService.create(desafioUsuario);
    }

    @PutMapping(value = "/{uuid}")
    @Transactional
    public ResponseEntity<?> update(@PathVariable UUID uuid, @RequestBody DesafioUsuario desafioUsuario) {
        return this.desafioUsuarioService.update(uuid, desafioUsuario);
    }

    @PutMapping(value = "/{uuid}/delete")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        return this.desafioUsuarioService.delete(uuid);
    }

}
