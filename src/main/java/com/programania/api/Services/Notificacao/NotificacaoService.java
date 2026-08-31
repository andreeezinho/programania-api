package com.programania.api.Services.Notificacao;

import com.programania.api.DTO.Notificacao.NotificacaoDTO;
import com.programania.api.Models.Notificacao.Notificacao;
import com.programania.api.Models.Usuario.Usuario;
import com.programania.api.Repositories.Notificacao.NotificacaoRepository;
import com.programania.api.Repositories.Usuario.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.UUID;

@Service
public class NotificacaoService {

    private final NotificacaoRepository notificacaoRepository;
    private final UsuarioRepository usuarioRepository;

    public NotificacaoService(NotificacaoRepository notificacaoRepository, UsuarioRepository usuarioRepository) {
        this.notificacaoRepository = notificacaoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.notificacaoRepository
                .findAll()
                .stream()
                .map(NotificacaoDTO::new)
                .toList());
    }

    public ResponseEntity<?> findByUuid(UUID uuid) {
        return this.notificacaoRepository
                .findByUuid(uuid)
                .map(record -> ResponseEntity.ok().body(new NotificacaoDTO(record)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> create(Notificacao notificacao) {
        if (notificacao.getUsuario() == null || notificacao.getUsuario().getId() == null) {
            return ResponseEntity.badRequest().body("usuario_id required");
        }

        Usuario user = this.usuarioRepository.findById(notificacao.getUsuario().getId()).orElse(null);
        if (user == null) return ResponseEntity.badRequest().body("usuario not found");

        notificacao.setUsuario(user);
        var saved = this.notificacaoRepository.save(notificacao);
        return ResponseEntity.ok(new NotificacaoDTO(saved));
    }

    @Transactional
    public ResponseEntity<?> update(UUID uuid, Notificacao notificacao) {
        return this.notificacaoRepository
                .findByUuid(uuid)
                .map(record -> {
                    record.setTitulo(notificacao.getTitulo());
                    record.setMensagem(notificacao.getMensagem());
                    record.setLido(notificacao.getLido());
                    record.setAtivo(notificacao.getAtivo());

                    if (notificacao.getUsuario() != null && notificacao.getUsuario().getId() != null) {
                        Usuario user = this.usuarioRepository.findById(notificacao.getUsuario().getId()).orElse(null);
                        if (user != null) record.setUsuario(user);
                    }

                    Notificacao update = this.notificacaoRepository.save(record);
                    return ResponseEntity.ok().body(new NotificacaoDTO(update));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    public ResponseEntity<?> delete(UUID uuid) {
        return this.notificacaoRepository
                .findByUuid(uuid)
                .map(record -> {
                    record.setAtivo(false);
                    Notificacao update = this.notificacaoRepository.save(record);
                    return ResponseEntity.ok().body(true);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}