package com.programania.api.Repositories.Desafio;

import com.programania.api.Models.Bloco.Bloco;
import com.programania.api.Models.Desafio.DesafioBloco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DesafioBlocoRepository extends JpaRepository<DesafioBloco, UUID> {

    List<DesafioBloco> findByDesafio_Id(Long desafioId);

    Optional<DesafioBloco> findByUuid(UUID uuid);

}
