package com.programania.api.Models.Desafio;

import com.programania.api.Models.Bloco.Bloco;
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
public class DesafioBloco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UuidGenerator
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(length = 36, unique = true, nullable = false, updatable = false)
    private UUID uuid;

    @Column(nullable = false, columnDefinition = "DEFAULT 1")
    private Integer ordem;

    @ManyToOne(optional = false)
    @JoinColumn(name = "desafios_id", nullable = false)
    private Desafio desafio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "blocos_id", nullable = false)
    private Bloco bloco;

    @Column(updatable = false)
    private Timestamp created_at;

    private Timestamp updated_at;

}
