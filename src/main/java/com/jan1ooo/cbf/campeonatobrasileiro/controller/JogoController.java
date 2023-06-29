package com.jan1ooo.cbf.campeonatobrasileiro.controller;

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
    public ResponseEntity<Boolean> finalizar(@PathVariable Long id, @RequestBody JogoDTO jogoDTO) {
        ResponseEntity.status(204).body(jogoService.finalizar(id, jogoDTO));
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/classificacao/{id}")
//    public ResponseEntity<Void> classificacao(@PathVariable Long id) {
//        ResponseEntity.ok().body(jogoService.obterClassificacao(id));
//        return null;
//    }

    @GetMapping("/jogo/{id}")
    public ResponseEntity<JogoDTO> obterJogo(@PathVariable Long id) {
        return ResponseEntity.ok().body(jogoService.obterJogo(id));
    }
}
