package com.programania.api.Repositories.Desafio;

import com.programania.api.Models.Desafio.DesafioUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DesafioUsuarioRepository extends JpaRepository<DesafioUsuario, UUID> {

    Optional<DesafioUsuario> findByUuid(UUID uuid);

}
