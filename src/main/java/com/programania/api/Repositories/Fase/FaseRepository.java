package com.programania.api.Repositories.Fase;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programania.api.Models.Fase.Fase;

@Repository
public interface FaseRepository extends JpaRepository<Fase, Long> {

    Optional<Fase> findByUuid(UUID uuid);

}
