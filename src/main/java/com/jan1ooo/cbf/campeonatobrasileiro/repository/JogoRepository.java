package com.jan1ooo.cbf.campeonatobrasileiro.repository;

import com.jan1ooo.cbf.campeonatobrasileiro.DTO.JogoDTO;
import com.jan1ooo.cbf.campeonatobrasileiro.DTO.TimeDTO;
import com.jan1ooo.cbf.campeonatobrasileiro.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<JogoDTO> findByTimeCasaAndEncerrado(TimeDTO time, boolean encerrado);

    List<JogoDTO> findByTimeForaAndEncerrado(TimeDTO time, boolean encerrado);
}
