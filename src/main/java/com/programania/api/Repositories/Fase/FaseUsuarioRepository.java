package com.programania.api.Repositories.Fase;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programania.api.Models.Fase.FaseUsuario;

@Repository
public interface FaseUsuarioRepository extends JpaRepository<FaseUsuario, Long> {

    Optional<FaseUsuario> findByUuid(UUID uuid);

}