package com.jan1ooo.cbf.campeonatobrasileiro.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JogoDTO {
    private Long id_jogo;
    private LocalDateTime data;
    private Integer golsTimeCasa;
    private Integer golsTimeFora;
    private Integer publicoPagante;
    private TimeDTO timeCasa;
    private TimeDTO timeFora;
    private Boolean encerrado;
    private Integer rodada;
}
