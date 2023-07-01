package com.jan1ooo.cbf.campeonatobrasileiro.controller;

import com.jan1ooo.cbf.campeonatobrasileiro.DTO.ClassificacaoDTO;
import com.jan1ooo.cbf.campeonatobrasileiro.DTO.JogoDTO;
import com.jan1ooo.cbf.campeonatobrasileiro.service.JogoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "Jogos", description = "API Jogos")
@RestController
@RequestMapping("/api/jogos")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public ResponseEntity<List<JogoDTO>> obterJogos() {
        return ResponseEntity.ok().body(jogoService.obterJogos());
    }

    @PostMapping("/gerar-jogos")
    public ResponseEntity<Void> gerarJogos() {
        jogoService.gerarJogos(LocalDateTime.now());
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/finalizar/{id}")
    public ResponseEntity<Void> finalizar(@PathVariable Long id, @RequestBody JogoDTO jogoDTO) throws Exception {
        jogoService.finalizarJogo(id, jogoDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/classificacao")
    public ResponseEntity<ClassificacaoDTO> obterClassificacao() {
        return ResponseEntity.ok().body(jogoService.obterClassificacao());
    }

    @GetMapping("/jogo/{id}")
    public ResponseEntity<JogoDTO> obterJogo(@PathVariable Long id) {
        return ResponseEntity.ok().body(jogoService.obterJogo(id));
    }
}
