package com.jan1ooo.cbf.campeonatobrasileiro.controller;

import com.jan1ooo.cbf.campeonatobrasileiro.DTO.TimeDTO;
import com.jan1ooo.cbf.campeonatobrasileiro.service.TimeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Tutorial", description = "Tutorial management APIs")
@RestController
@RequestMapping("/api/times")
public class TimeController {

    @Autowired
    private TimeService service;

    @GetMapping
    public ResponseEntity<List<TimeDTO>> getTimes() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<TimeDTO> postTime(@Valid @RequestBody TimeDTO time) {
        return ResponseEntity.status(201).body(service.save(time));
    }
}
