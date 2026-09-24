package com.programania.api.Services.Desafio;

import com.programania.api.DTO.Desafio.DesafioDTO;
import com.programania.api.Models.Desafio.Desafio;
import com.programania.api.Repositories.Desafio.DesafioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DesafioService {

    private final DesafioRepository desafioRepository;

    public Page<DesafioDTO> listarTodos(Pageable pageable) {
        return desafioRepository.findAll(pageable)
                .map(DesafioDTO::new);
    }

    public Page<DesafioDTO> listarPorFase(int faseId, Pageable pageable) {
        return desafioRepository.findByFaseIdAndAtivo(faseId, true, pageable)
                .map(DesafioDTO::new);
    }

    public DesafioDTO buscarPorId(UUID uuid) {
        return desafioRepository.findById(uuid)
                .map(DesafioDTO::new)
                .orElseThrow(() -> new RuntimeException("Desafio não encontrado"));
    }

    public DesafioDTO buscarPorNome(String nome) {
        return desafioRepository.findByNome(nome)
                .map(DesafioDTO::new)
                .orElseThrow(() -> new RuntimeException("Desafio não encontrado"));
    }

    public DesafioDTO criar(DesafioDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Dados do desafio não podem ser nulos");
        }

        desafioRepository.findByNome(dto.nome())
                .ifPresent(d -> {
                    throw new IllegalArgumentException("Já existe um desafio com esse nome");
                });

        Desafio desafio = new Desafio();
        desafio.setNome(dto.nome());
        desafio.setDescricao(dto.descricao());
        desafio.setDicas(dto.dicas());
        desafio.setFaseId(dto.faseId());
        desafio.setAtivo(dto.ativo() != null ? dto.ativo() : true);

        Desafio salvo = desafioRepository.save(desafio);
        return new DesafioDTO(salvo);
    }

    public DesafioDTO atualizar(UUID uuid, DesafioDTO dto) {
        Desafio desafio = desafioRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Desafio não encontrado"));

        desafio.setNome(dto.nome());
        desafio.setDescricao(dto.descricao());
        desafio.setDicas(dto.dicas());
        desafio.setFaseId(dto.faseId());
        desafio.setAtivo(dto.ativo() != null ? dto.ativo() : desafio.getAtivo());

        Desafio atualizado = desafioRepository.save(desafio);
        return new DesafioDTO(atualizado);
    }

    public void excluir(UUID uuid) {
        if (!desafioRepository.existsById(uuid)) {
            throw new RuntimeException("Desafio não encontrado");
        }
        desafioRepository.deleteById(uuid);
    }
}