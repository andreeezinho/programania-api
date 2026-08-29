package com.programania.api.Repositories.Notificacao;

import com.programania.api.Models.Notificacao.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
    Optional<Notificacao> findByUuid(UUID uuid);
}