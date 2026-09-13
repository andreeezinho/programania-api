package com.programania.api.Repositories.Desafio;

import com.programania.api.Models.Desafio.DesafioBloco;
import com.programania.api.Models.Desafio.DesafioBlocoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DesafioBlocoUsuarioRepository extends JpaRepository<DesafioBlocoUsuario, UUID> {

    Optional<DesafioBlocoUsuario> findByUuid(UUID uuid);

}
