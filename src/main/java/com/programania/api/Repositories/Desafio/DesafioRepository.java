package com.programania.api.Repositories.Desafio;

import com.programania.api.Models.Desafio.Desafio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface DesafioRepository extends JpaRepository<Desafio, UUID> {
    Page<Desafio> findByFaseIdAndAtivo(int faseId, Boolean ativo, Pageable pageable);
    Optional<Desafio> findByNome(String nome);
}
