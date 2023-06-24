package com.jan1ooo.cbf.campeonatobrasileiro.DTO;

import java.time.LocalDateTime;

public record JogoDTO(
        Long id_jogo,
        LocalDateTime data,
        Integer golsTimeCasa,
        Integer golsTimeFora,
        Double publicoPagante,
        TimeDTO timeCasa,
        TimeDTO timeFora,
        Boolean encerrado,
        Integer rodada
) {
}
