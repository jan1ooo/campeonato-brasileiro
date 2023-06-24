package com.jan1ooo.cbf.campeonatobrasileiro.DTO.mapper;

import com.jan1ooo.cbf.campeonatobrasileiro.DTO.JogoDTO;
import com.jan1ooo.cbf.campeonatobrasileiro.DTO.TimeDTO;
import com.jan1ooo.cbf.campeonatobrasileiro.entity.Jogo;
import com.jan1ooo.cbf.campeonatobrasileiro.entity.Time;
import org.springframework.stereotype.Component;

@Component
public class JogoMapper {

    public JogoDTO toDTO(Jogo jogo) {
        if (jogo == null) {
            return null;
        }

        TimeDTO timeCasa = new TimeDTO(
                jogo.getTimeCasa().getId_time(),
                jogo.getTimeCasa().getNome(),
                jogo.getTimeCasa().getSigla(),
                jogo.getTimeCasa().getUf());

        TimeDTO timeFora = new TimeDTO(
                jogo.getTimeFora().getId_time(),
                jogo.getTimeFora().getNome(),
                jogo.getTimeFora().getSigla(),
                jogo.getTimeFora().getUf());

        return new JogoDTO(
                jogo.getId_jogo(),
                jogo.getData(),
                jogo.getGolsTimeCasa(),
                jogo.getGolsTimeFora(),
                jogo.getPublicoPagante(),
                timeCasa,
                timeFora,
                jogo.getEncerrado(),
                jogo.getRodada()
        );
    }

    public Jogo toEntity(JogoDTO jogoDTO) {
        if (jogoDTO == null) {
            return null;
        }

        Jogo jogo = new Jogo();
        if (jogoDTO.id_jogo() != null) {
            jogo.setId_jogo(jogo.getId_jogo());
        }

        Time timeCasa = new Time(
                jogoDTO.timeCasa().id_time(),
                jogoDTO.timeCasa().nome(),
                jogoDTO.timeCasa().sigla(),
                jogoDTO.timeCasa().uf());

        Time timeFora = new Time(
                jogoDTO.timeFora().id_time(),
                jogoDTO.timeFora().nome(),
                jogoDTO.timeFora().sigla(),
                jogoDTO.timeFora().uf());

        jogo.setData(jogoDTO.data());
        jogo.setGolsTimeCasa(jogoDTO.golsTimeCasa());
        jogo.setGolsTimeFora(jogoDTO.golsTimeFora());
        jogo.setPublicoPagante(jogoDTO.publicoPagante());
        jogo.setTimeCasa(timeCasa);
        jogo.setTimeFora(timeFora);
        jogo.setEncerrado(jogoDTO.encerrado());
        jogo.setRodada(jogoDTO.rodada());
        return jogo;
    }
}
