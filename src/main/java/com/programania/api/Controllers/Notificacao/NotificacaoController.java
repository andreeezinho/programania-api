package com.programania.api.Controllers.Notificacao;

import com.programania.api.Models.Notificacao.Notificacao;
import com.programania.api.Services.Notificacao.NotificacaoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/notifications")
public class NotificacaoController {

    @Autowired
    NotificacaoService notificacaoService;

    @GetMapping
    public ResponseEntity<?> index() {
        return notificacaoService.findAll();
    }

    @GetMapping(path = {"/{uuid}"})
    public ResponseEntity<?> findByUuid(@PathVariable UUID uuid){
        return this.notificacaoService.findByUuid(uuid);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody Notificacao notificacao) {
        return this.notificacaoService.create(notificacao);
    }

    @PutMapping(value = "/{uuid}")
    @Transactional
    public ResponseEntity<?> update(@PathVariable UUID uuid, @RequestBody Notificacao notificacao) {
        return this.notificacaoService.update(uuid, notificacao);
    }

    @PutMapping(value = "/{uuid}/delete")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        return this.notificacaoService.delete(uuid);
    }

}