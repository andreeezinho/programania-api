package com.programania.api.Controllers.Usuario;

import java.util.UUID;

import com.programania.api.DTO.Usuario.UsuarioPasswordDTO;
import com.programania.api.Models.Usuario.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.programania.api.Services.Usuario.UsuarioService;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<?> index() {
        return usuarioService.findAll();
    }

    @GetMapping(path = {"/{uuid}"})
    public ResponseEntity<?> findByUuid(@PathVariable UUID uuid){
        return this.usuarioService.findByUuid(uuid);
    }

    @GetMapping(path = {"/me"})
    public ResponseEntity<?> userPerfil(@AuthenticationPrincipal UserDetails userDetails){
        return this.usuarioService.userPerfil(userDetails);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody Usuario usuario) {
        return this.usuarioService.create(usuario);
    }

    @PutMapping(value = "/{uuid}")
    @Transactional
    public ResponseEntity<?> update(@PathVariable UUID uuid, @RequestBody Usuario usuario) {
        return this.usuarioService.update(uuid, usuario);
    }

    @PutMapping(value = "/{uuid}/password")
    @Transactional
    public ResponseEntity<?> updatePassword(@PathVariable UUID uuid, @RequestBody UsuarioPasswordDTO password) {
        return this.usuarioService.updatePassword(uuid, password);
    }

    @PutMapping(value = "/{uuid}/delete")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        return this.usuarioService.delete(uuid);
    }

}
