package com.programania.api.Controllers.Bloco;

import com.programania.api.Models.Bloco.Bloco;
import com.programania.api.Services.Bloco.BlocoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/blocks")
public class BlocoController {

    @Autowired
    BlocoService blocoService;

    @GetMapping
    public ResponseEntity<?> index() {
        return blocoService.findAll();
    }

    @GetMapping(path = {"/{uuid}"})
    public ResponseEntity<?> findByUuid(@PathVariable UUID uuid){
        return this.blocoService.findByUuid(uuid);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody Bloco bloco) {
        return this.blocoService.create(bloco);
    }

    @PutMapping(value = "/{uuid}")
    @Transactional
    public ResponseEntity<?> update(@PathVariable UUID uuid, @RequestBody Bloco bloco) {
        return this.blocoService.update(uuid, bloco);
    }

    @PutMapping(value = "/{uuid}/delete")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        return this.blocoService.delete(uuid);
    }

}
