package com.jan1ooo.cbf.campeonatobrasileiro.controller;

import com.jan1ooo.cbf.campeonatobrasileiro.entity.Time;
import com.jan1ooo.cbf.campeonatobrasileiro.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/times")
public class TimeController {

    @Autowired
    private TimeService service;

    @GetMapping
    public ResponseEntity<List<Time>> getTimes() {
        return ResponseEntity.ok().body(service.listarTimes());
    }
}
