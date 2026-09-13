package com.programania.api.Controllers.Desafio;

import com.programania.api.Models.Desafio.DesafioBloco;
import com.programania.api.Services.Desafio.DesafioBlocoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RestController("/desafio-bloco")
public class DesafioBlocoController {

    @Autowired
    DesafioBlocoService desafioBlocoService;

    @GetMapping
    public ResponseEntity<?> index() {
        return desafioBlocoService.findAll();
    }

    @GetMapping(path = {"/{uuid}"})
    public ResponseEntity<?> findByUuid(@PathVariable UUID uuid){
        return this.desafioBlocoService.findByUuid(uuid);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody DesafioBloco desafioBloco) {
        return this.desafioBlocoService.create(desafioBloco);
    }

    @PutMapping(value = "/{uuid}")
    @Transactional
    public ResponseEntity<?> update(@PathVariable UUID uuid, @RequestBody DesafioBloco desafioBloco) {
        return this.desafioBlocoService.update(uuid, desafioBloco);
    }

    @PutMapping(value = "/{uuid}/delete")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        return this.desafioBlocoService.delete(uuid);
    }

}
