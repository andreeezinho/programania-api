package com.programania.api.Models.Desafio;

import com.programania.api.Models.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class DesafioBlocoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UuidGenerator
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(length = 36, unique = true, nullable = false, updatable = false)
    private UUID uuid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "desafio_bloco_id", nullable = false)
    private DesafioBloco desafioBloco;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuarios_id", nullable = false)
    private Usuario usuario;

    @Column(updatable = false)
    private Timestamp created_at;

    private Timestamp updated_at;

}
