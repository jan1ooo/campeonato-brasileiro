package com.jan1ooo.cbf.campeonatobrasileiro.repository;

import com.jan1ooo.cbf.campeonatobrasileiro.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
}
