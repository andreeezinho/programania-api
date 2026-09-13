package com.programania.api.Controllers.Desafio;

import com.programania.api.Models.Desafio.DesafioBloco;
import com.programania.api.Models.Desafio.DesafioBlocoUsuario;
import com.programania.api.Services.Desafio.DesafioBlocoUsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RestController("/desafio-bloco-usuario")
public class DesafioBlocoUsuarioController {

    @Autowired
    DesafioBlocoUsuarioService desafioBlocoUsuarioService;

    @GetMapping
    public ResponseEntity<?> index() {
        return desafioBlocoUsuarioService.findAll();
    }

    @GetMapping(path = {"/{uuid}"})
    public ResponseEntity<?> findByUuid(@PathVariable UUID uuid){
        return this.desafioBlocoUsuarioService.findByUuid(uuid);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody DesafioBlocoUsuario desafioBlocoUsuario) {
        return this.desafioBlocoUsuarioService.create(desafioBlocoUsuario);
    }

    @PutMapping(value = "/{uuid}/delete")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        return this.desafioBlocoUsuarioService.delete(uuid);
    }


}
