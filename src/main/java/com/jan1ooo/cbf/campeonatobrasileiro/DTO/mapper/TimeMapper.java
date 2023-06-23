package com.jan1ooo.cbf.campeonatobrasileiro.DTO.mapper;

import com.jan1ooo.cbf.campeonatobrasileiro.DTO.TimeDTO;
import com.jan1ooo.cbf.campeonatobrasileiro.entity.Time;
import org.springframework.stereotype.Component;

@Component
public class TimeMapper {
    public TimeDTO toDTO(Time time) {
        if (time == null) {
            return null;
        }
        return new TimeDTO(time.getId_time(), time.getNome(), time.getSigla(), time.getUf());
    }

    public Time toEntity(TimeDTO timeDTO) {
        if (timeDTO == null) {
            return null;
        }

        Time time = new Time();
        if (timeDTO.id_time() != null) {
            time.setId_time(timeDTO.id_time());
        }
        time.setNome(timeDTO.nome());
        time.setSigla(timeDTO.sigla());
        time.setUf(timeDTO.uf());
        return time;

    }
}
