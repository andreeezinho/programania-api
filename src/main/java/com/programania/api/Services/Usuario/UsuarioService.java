package com.programania.api.Services.Usuario;

import com.programania.api.DTO.Usuario.UsuarioDTO;
import com.programania.api.DTO.Usuario.UsuarioPasswordDTO;
import com.programania.api.Models.Usuario.Usuario;
import com.programania.api.Repositories.Usuario.UsuarioRepository;

import com.programania.api.Services.Infra.PasswordVerificationService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;
    private PasswordVerificationService passwordVerificationService;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, PasswordVerificationService passwordVerificationService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.passwordVerificationService = passwordVerificationService;
    }

    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioDTO::new)
                .toList());
    }

    public ResponseEntity<?> findByUuid(UUID uuid){
        return this.usuarioRepository
                .findByUuid(uuid)
                .map(record -> ResponseEntity.ok().body(new UsuarioDTO(record)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> findById(Long id){
        return this.usuarioRepository
                .findById(id)
                .map(record -> ResponseEntity.ok().body(new UsuarioDTO(record)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> userPerfil(UserDetails userDetails){
        return ResponseEntity.ok(new UsuarioDTO((Usuario) userDetails));
    }

    public ResponseEntity<?> create(Usuario usuario) {
        if(this.usuarioRepository.findByLogin(usuario.getLogin()) != null) return ResponseEntity.badRequest().build();

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        return ResponseEntity.ok(new UsuarioDTO(
                this.usuarioRepository.save(usuario)
        ));
    }

    public ResponseEntity<?> update(UUID uuid, Usuario usuario) {
        return this.usuarioRepository
                .findByUuid(uuid)
                .map(record -> {
                    record.setLogin(usuario.getLogin());
                    record.setNome(usuario.getNome());
                    record.setEmail(usuario.getEmail());
                    record.setAtivo(usuario.getAtivo());

                    Usuario update  = this.usuarioRepository.save(record);
                    return ResponseEntity.ok().body(new UsuarioDTO(update));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> updatePassword(UUID uuid, UsuarioPasswordDTO password) {
        var user = this.usuarioRepository.findByUuid(uuid);

        Boolean verifiedPassword = this.passwordVerificationService.verify(user.get().getPassword(), password);

        if(!verifiedPassword){
            return ResponseEntity.notFound().build();
        }

        return user
                .map(record -> {
                    record.setPassword(passwordEncoder.encode(password.novaSenha()));

                    this.usuarioRepository.save(record);
                    return ResponseEntity.ok().body(true);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> delete(UUID uuid) {
        return this.usuarioRepository
                .findByUuid(uuid)
                .map(record -> {
                    record.setAtivo(false);

                    Usuario update  = this.usuarioRepository.save(record);
                    return ResponseEntity.ok().body(true);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
