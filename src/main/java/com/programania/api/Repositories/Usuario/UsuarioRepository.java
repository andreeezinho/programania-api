package com.programania.api.Repositories.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.programania.api.Models.Usuario.Usuario;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository  extends JpaRepository <Usuario, Long>{

    Optional<Usuario> findByUuid(UUID uuid);

    UserDetails findByEmail(String email);

}
