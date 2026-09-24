package com.programania.api.Controllers.Desafio;

import com.programania.api.DTO.Desafio.DesafioDTO;
import com.programania.api.Services.Desafio.DesafioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/desafios")
@RequiredArgsConstructor
public class DesafioController {

    private final DesafioService desafioService;

    @GetMapping
    public ResponseEntity<Page<DesafioDTO>> listarTodos(Pageable pageable) {
        return ResponseEntity.ok(desafioService.listarTodos(pageable));
    }

    @GetMapping("/fase/{faseId}")
    public ResponseEntity<Page<DesafioDTO>> listarPorFase(@PathVariable int faseId, Pageable pageable) {
        return ResponseEntity.ok(desafioService.listarPorFase(faseId, pageable));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<DesafioDTO> buscarPorId(@PathVariable UUID uuid) {
        return ResponseEntity.ok(desafioService.buscarPorId(uuid));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<DesafioDTO> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(desafioService.buscarPorNome(nome));
    }

    @PostMapping
    public ResponseEntity<DesafioDTO> criar(@RequestBody DesafioDTO dto) {
        DesafioDTO salvo = desafioService.criar(dto);

        URI uri = URI.create("/desafios/" + salvo.uuid());
        return ResponseEntity.created(uri).body(salvo);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<DesafioDTO> atualizar(@PathVariable UUID uuid, @RequestBody DesafioDTO dto) {
        return ResponseEntity.ok(desafioService.atualizar(uuid, dto));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> excluir(@PathVariable UUID uuid) {
        desafioService.excluir(uuid);
        return ResponseEntity.noContent().build();
    }
}