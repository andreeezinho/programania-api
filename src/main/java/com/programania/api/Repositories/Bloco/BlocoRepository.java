package com.programania.api.Repositories.Bloco;

import com.programania.api.Models.Bloco.Bloco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BlocoRepository extends JpaRepository <Bloco, Long> {

    Optional<Bloco> findByUuid(UUID uuid);

}
