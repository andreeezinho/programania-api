package com.programania.api.Services.Bloco;

import com.programania.api.Models.Bloco.Bloco;
import com.programania.api.DTO.Bloco.BlocoDTO;
import com.programania.api.Repositories.Bloco.BlocoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.http.ResponseEntity;

import java.util.UUID;

@Service
public class BlocoService {

    @Autowired
    BlocoRepository blocoRepository;

    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.blocoRepository
                .findAll()
                .stream()
                .map(BlocoDTO::new)
                .toList());
    }

    public ResponseEntity<?> findByUuid(UUID uuid){
        return this.blocoRepository
                .findByUuid(uuid)
                .map(record -> ResponseEntity.ok().body(new BlocoDTO(record)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> findById(Long id){
        return this.blocoRepository
                .findById(id)
                .map(record -> ResponseEntity.ok().body(new BlocoDTO(record)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> create(Bloco usuario) {
        return ResponseEntity.ok(new BlocoDTO(
                this.blocoRepository.save(usuario)
        ));
    }

    public ResponseEntity<?> update(UUID uuid, Bloco usuario) {
        return this.blocoRepository
                .findByUuid(uuid)
                .map(record -> {
                    record.setCodigo(usuario.getCodigo());
                    record.setTipo(usuario.getTipo());
                    record.setAtivo(usuario.getAtivo());

                    Bloco update  = this.blocoRepository.save(record);
                    return ResponseEntity.ok().body(new BlocoDTO(update));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> delete(UUID uuid) {
        return this.blocoRepository
                .findByUuid(uuid)
                .map(record -> {
                    record.setAtivo(false);

                    Bloco update  = this.blocoRepository.save(record);
                    return ResponseEntity.ok().body(true);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
