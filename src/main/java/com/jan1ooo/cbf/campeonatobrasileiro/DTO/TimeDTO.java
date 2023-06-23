package com.jan1ooo.cbf.campeonatobrasileiro.DTO;

import jakarta.validation.constraints.NotBlank;

public record TimeDTO(Long id_time,
                      @NotBlank String nome,
                      @NotBlank String sigla,
                      @NotBlank String uf) {


}
