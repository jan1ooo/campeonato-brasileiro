package com.jan1ooo.cbf.campeonatobrasileiro.repository;

import com.jan1ooo.cbf.campeonatobrasileiro.entity.Jogo;
import com.jan1ooo.cbf.campeonatobrasileiro.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<Jogo> findByTimeCasaAndEncerrado(Time time, boolean encerrado);

    List<Jogo> findByTimeForaAndEncerrado(Time time, boolean encerrado);


}
