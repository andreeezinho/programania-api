package com.programania.api.Services.Fase;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.programania.api.Models.Fase.Fase;
import com.programania.api.Repositories.Fase.FaseRepository;

@Service
public class FaseService {

    private FaseRepository faseRepository;

    public FaseService(FaseRepository faseRepository) {
        this.faseRepository = faseRepository;
    }

    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(this.faseRepository.findAll());

    }

    public ResponseEntity<?> findByUuid(UUID uuid) {

        return this.faseRepository.findByUuid(uuid).map(record -> ResponseEntity.ok(record)).orElse(ResponseEntity
                .notFound().build());
    }

    public ResponseEntity<?> create(Fase fase) {

        return ResponseEntity.ok(this.faseRepository.save(fase));

    }

    public ResponseEntity<?> update(UUID uuid, Fase fase) {

        return this.faseRepository.findByUuid(uuid).map(record -> {

            record.setNumero(fase.getNumero());
            record.setNome(fase.getNome());
            record.setAtivo(fase.getAtivo());

            Fase update = this.faseRepository.save(record);

            return ResponseEntity.ok().body(update);

        }).orElse(ResponseEntity.notFound().build());

    }

    public ResponseEntity<?> delete(UUID uuid) {

        return this.faseRepository.findByUuid(uuid).map(record -> {

            record.setAtivo(false);

            this.faseRepository.save(record);

            return ResponseEntity.ok().body(true);

        }).orElse(ResponseEntity.notFound().build());
    }
}
