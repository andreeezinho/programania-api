package com.programania.api.Services.Desafio;

import com.programania.api.DTO.Desafio.DesafioBlocoDTO;
import com.programania.api.Models.Desafio.DesafioBloco;
import com.programania.api.Repositories.Desafio.DesafioBlocoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DesafioBlocoService {

    @Autowired
    DesafioBlocoRepository desafioBlocoRepository;

    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.desafioBlocoRepository
                .findAll()
                .stream()
                .map(DesafioBlocoDTO::new)
                .toList());
    }

    public ResponseEntity<?> findByUuid(UUID uuid){
        return this.desafioBlocoRepository
                .findByUuid(uuid)
                .map(record -> ResponseEntity.ok().body(new DesafioBlocoDTO(record)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> create(DesafioBloco desafioBloco) {
        return ResponseEntity.ok(new DesafioBlocoDTO(
                this.desafioBlocoRepository.save(desafioBloco)
        ));
    }

    public ResponseEntity<?> update(UUID uuid, DesafioBloco desafioBloco) {
        return this.desafioBlocoRepository
                .findByUuid(uuid)
                .map(record -> {
                    record.setOrdem(desafioBloco.getOrdem());

                    DesafioBloco update  = this.desafioBlocoRepository.save(record);
                    return ResponseEntity.ok().body(new DesafioBlocoDTO(update));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> delete(UUID uuid) {
        DesafioBloco desafioBloco = desafioBlocoRepository
                .findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Bloco ou Desafio não encontrado"));

        this.desafioBlocoRepository.delete(desafioBloco);

        return ResponseEntity.ok("Bloco do desafio deletado");
    }

}
