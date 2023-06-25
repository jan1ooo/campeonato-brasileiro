package com.jan1ooo.cbf.campeonatobrasileiro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jogo {

    @Id
    private Long id_jogo;
    private LocalDateTime data;
    private Integer golsTimeCasa;
    private Integer golsTimeFora;
    private Integer publicoPagante;
    private Boolean encerrado;
    private Integer rodada;

    @ManyToOne
    @JoinColumn(name = "timeCasa")
    private Time timeCasa;

    @ManyToOne
    @JoinColumn(name = "timeVisitante")
    private Time timeFora;
}

