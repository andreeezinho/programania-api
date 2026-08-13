package com.programania.api.Controllers.Fase;

import java.util.UUID;

import jakarta.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.programania.api.Models.Fase.Fase;
import com.programania.api.Services.Fase.FaseService;

@RestController
@RequestMapping("/phases")
public class FaseController {

    private FaseService faseService;

    public FaseController(FaseService faseService) {

        this.faseService = faseService;

    }

    @GetMapping
    public ResponseEntity<?> index() {

        return this.faseService.findAll();

    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> findByUuid(@PathVariable UUID uuid) {

        return this.faseService.findByUuid(uuid);

    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody Fase fase) {

        return this.faseService.create(fase);

    }

    @PutMapping("/{uuid}")
    @Transactional
    public ResponseEntity<?> update(@PathVariable UUID uuid, @RequestBody Fase fase) {

        return this.faseService.update(uuid, fase);

    }

    @PutMapping("/{uuid}/delete")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {

        return this.faseService.delete(uuid);

    }

}
