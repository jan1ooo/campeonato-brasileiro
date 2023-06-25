package com.jan1ooo.cbf.campeonatobrasileiro.service;

import com.jan1ooo.cbf.campeonatobrasileiro.DTO.JogoDTO;
import com.jan1ooo.cbf.campeonatobrasileiro.DTO.TimeDTO;
import com.jan1ooo.cbf.campeonatobrasileiro.DTO.mapper.JogoMapper;
import com.jan1ooo.cbf.campeonatobrasileiro.DTO.mapper.TimeMapper;
import com.jan1ooo.cbf.campeonatobrasileiro.entity.Jogo;
import com.jan1ooo.cbf.campeonatobrasileiro.repository.JogoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JogoService {

    @Autowired
    private final JogoRepository jogoRepository;

    @Autowired
    JogoMapper jogoMapper;

    @Autowired
    TimeService timeService;

    @Autowired
    TimeMapper timeMapper;

    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<JogoDTO> findAll() {
        return jogoRepository.findAll()
                .stream()
                .map(jogoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public JogoDTO create(@Valid @NotNull JogoDTO jogoDTO) {
        return jogoMapper.toDTO(jogoRepository.save(jogoMapper.toEntity(jogoDTO)));
    }

    public void gerarJogos(LocalDateTime primeiraRodada) {
        final List<TimeDTO> times = timeService.findAll();
        List<TimeDTO> all1 = new ArrayList<>();
        List<TimeDTO> all2 = new ArrayList<>();
        all1.addAll(times);//.subList(0, times.size()/2));
        all2.addAll(times);//.subList(all1.size(), times.size()));

        jogoRepository.deleteAll();

        List<JogoDTO> jogos = new ArrayList<>();

        int t = times.size();
        int m = times.size() / 2;
        LocalDateTime dataJogo = primeiraRodada;
        Integer rodada = 0;
        for (int i = 0; i < t - 1; i++) {
            rodada = i + 1;
            for (int j = 0; j < m; j++) {
                //Teste para ajustar o mando de campo
                TimeDTO timeCasa;
                TimeDTO timeFora;
                if (j % 2 == 1 || i % 2 == 1 && j == 0) {
                    timeCasa = times.get(t - j - 1);
                    timeFora = times.get(j);
                } else {
                    timeCasa = times.get(j);
                    timeFora = times.get(t - j - 1);
                }
                if (timeCasa == null) {
                    System.out.println("Time  1 null");
                }
                jogos.add(gerarJogo(dataJogo, rodada, timeCasa, timeFora));
                dataJogo = dataJogo.plusDays(7);
            }
            //Gira os times no sentido horário, mantendo o primeiro no lugar
            times.add(1, times.remove(times.size() - 1));
        }

        jogos.forEach(jogo -> System.out.println(jogo));

        for (JogoDTO jogo : jogos) {
            jogoRepository.save(jogoMapper.toEntity(jogo));
        }

        List<JogoDTO> jogos2 = new ArrayList<>();

        jogos.forEach(jogo -> {
            TimeDTO timeCasa = jogo.getTimeCasa();
            TimeDTO timeFora = jogo.getTimeFora();
            jogos2.add(gerarJogo(jogo.getData().plusDays(7L * jogos.size()), jogo.getRodada() + jogos.size(), timeCasa, timeFora));
        });

        for (JogoDTO jogo : jogos2) {
            jogoRepository.save(jogoMapper.toEntity(jogo));
        }
    }

    private JogoDTO gerarJogo(LocalDateTime dataJogo, Integer rodada, TimeDTO timeCasa, TimeDTO timeFora) {
        Jogo jogo = new Jogo();
        jogo.setId_jogo(1L);
        jogo.setTimeCasa(timeMapper.toEntity(timeCasa));
        jogo.setTimeFora(timeMapper.toEntity(timeFora));
        jogo.setRodada(3);
        jogo.setData(dataJogo);
        jogo.setGolsTimeCasa(3);
        jogo.setGolsTimeFora(0);
        jogo.setPublicoPagante(40000);
        jogo.setEncerrado(true);

        return jogoMapper.toDTO(jogo);
    }
}
