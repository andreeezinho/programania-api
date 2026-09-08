package com.programania.api.Models.Desafio;

import com.programania.api.Models.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class DesafioUsuario {

    @Id
    @UuidGenerator
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(length = 36, unique = true, nullable = false, updatable = false)
    private UUID uuid;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0", nullable = false)
    private Boolean completa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "desafios_id", nullable = false)
    private Desafio desafio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuarios_id", nullable = false)
    private Usuario usuario;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

}
