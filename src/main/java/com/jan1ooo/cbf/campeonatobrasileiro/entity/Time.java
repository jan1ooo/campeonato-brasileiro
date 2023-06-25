package com.jan1ooo.cbf.campeonatobrasileiro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_time;

    @Column(length = 20)
    private String nome;

    @Column(length = 4)
    private String sigla;

    @Column(length = 2)
    private String uf;

}
