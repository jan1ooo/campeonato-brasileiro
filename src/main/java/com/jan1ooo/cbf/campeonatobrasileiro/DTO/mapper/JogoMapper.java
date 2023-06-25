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

        JogoDTO jogoDTO = new JogoDTO();
        jogoDTO.setId_jogo(jogo.getId_jogo());
        jogoDTO.setData(jogo.getData());
        jogoDTO.setTimeCasa(timeCasa);
        jogoDTO.setTimeFora(timeFora);
        jogoDTO.setPublicoPagante(jogo.getPublicoPagante());
        jogoDTO.setGolsTimeCasa(jogo.getGolsTimeCasa());
        jogoDTO.setGolsTimeFora(jogo.getGolsTimeFora());
        jogoDTO.setEncerrado(jogo.getEncerrado());

        return jogoDTO;
    }

    public Jogo toEntity(JogoDTO jogoDTO) {
        if (jogoDTO == null) {
            return null;
        }

        Jogo jogo = new Jogo();
        if (jogoDTO.getId_jogo() != null) {
            jogo.setId_jogo(jogo.getId_jogo());
        }

        Time timeCasa = new Time(
                jogoDTO.getTimeCasa().id_time(),
                jogoDTO.getTimeCasa().nome(),
                jogoDTO.getTimeCasa().sigla(),
                jogoDTO.getTimeCasa().uf());

        Time timeFora = new Time(
                jogoDTO.getTimeFora().id_time(),
                jogoDTO.getTimeFora().nome(),
                jogoDTO.getTimeFora().sigla(),
                jogoDTO.getTimeFora().uf());

        jogo.setData(jogoDTO.getData());
        jogo.setGolsTimeCasa(jogoDTO.getGolsTimeCasa());
        jogo.setGolsTimeFora(jogoDTO.getGolsTimeFora());
        jogo.setPublicoPagante(jogoDTO.getPublicoPagante());
        jogo.setTimeCasa(timeCasa);
        jogo.setTimeFora(timeFora);
        jogo.setEncerrado(jogoDTO.getEncerrado());
        jogo.setRodada(jogoDTO.getRodada());
        return jogo;
    }
}
