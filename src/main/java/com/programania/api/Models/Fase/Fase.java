package com.programania.api.Models.Fase;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Fase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UuidGenerator
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(length = 36, nullable = false, unique = true, updatable = false)
    private UUID uuid;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 1", nullable = false)
    private Boolean ativo;

    @Column(updatable = false)
    private Timestamp created_at;

    private Timestamp updated_at;
}