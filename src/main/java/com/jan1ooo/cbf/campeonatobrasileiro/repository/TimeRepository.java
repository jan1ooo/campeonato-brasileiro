package com.jan1ooo.cbf.campeonatobrasileiro.repository;

import com.jan1ooo.cbf.campeonatobrasileiro.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
}
