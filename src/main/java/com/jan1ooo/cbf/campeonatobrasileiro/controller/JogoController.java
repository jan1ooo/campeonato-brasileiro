package com.jan1ooo.cbf.campeonatobrasileiro.controller;

import com.jan1ooo.cbf.campeonatobrasileiro.DTO.JogoDTO;
import com.jan1ooo.cbf.campeonatobrasileiro.service.JogoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "Jogos", description = "API Jogos")
@RestController
@RequestMapping("/api/jogos")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public ResponseEntity<List<JogoDTO>> getJogos() {
        return ResponseEntity.ok().body(jogoService.findAll());
    }

//    @PostMapping
//    public ResponseEntity<JogoDTO> save(@RequestBody JogoDTO jogoDTO) {
//        return ResponseEntity.status(201).body(jogoService.create(jogoDTO));
//    }

    @PostMapping("/gerar-jogos")
    public ResponseEntity<Void> gerarJogos() {
        jogoService.gerarJogos(LocalDateTime.now());
        return ResponseEntity.ok().build();
    }
}
