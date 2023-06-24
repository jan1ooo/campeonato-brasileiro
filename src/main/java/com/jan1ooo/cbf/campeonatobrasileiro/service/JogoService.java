package com.jan1ooo.cbf.campeonatobrasileiro.service;

import com.jan1ooo.cbf.campeonatobrasileiro.DTO.JogoDTO;
import com.jan1ooo.cbf.campeonatobrasileiro.DTO.TimeDTO;
import com.jan1ooo.cbf.campeonatobrasileiro.DTO.mapper.JogoMapper;
import com.jan1ooo.cbf.campeonatobrasileiro.DTO.mapper.TimeMapper;
import com.jan1ooo.cbf.campeonatobrasileiro.entity.Jogo;
import com.jan1ooo.cbf.campeonatobrasileiro.entity.Time;
import com.jan1ooo.cbf.campeonatobrasileiro.repository.JogoRepository;
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
    JogoMapper jogoMapper;
    TimeService timeService;
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

    public void gerarJogos(LocalDateTime primeiraRodada) {
        final List<TimeDTO> times = timeService.findAll();
        List<TimeDTO> all1 = new ArrayList<>();
        List<TimeDTO> all2 = new ArrayList<>();
        all1.addAll(times);//.subList(0, times.size()/2));
        all2.addAll(times);//.subList(all1.size(), times.size()));

        jogoRepository.deleteAll();

        List<Jogo> jogos = new ArrayList<>();

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


        jogoRepository.saveAll(jogos);

        List<Jogo> jogos2 = new ArrayList<>();

        jogos.forEach(jogo -> {
            TimeDTO timeCasa = timeMapper.toDTO(jogo.getTimeCasa());
            TimeDTO timeFora = timeMapper.toDTO(jogo.getTimeFora());
            jogos2.add(gerarJogo(jogo.getData().plusDays(7L * jogos.size()), jogo.getRodada() + jogos.size(), timeCasa, timeFora));
        });
        jogoRepository.saveAll(jogos2);
    }

    private Jogo gerarJogo(LocalDateTime dataJogo, Integer rodada, TimeDTO timeCasa, TimeDTO timeFora) {
        Time time1 = new Time(timeCasa.id_time(), timeCasa.nome(), timeCasa.sigla(), timeCasa.uf());
        Time time2 = new Time(timeFora.id_time(), timeFora.nome(), timeFora.sigla(), timeFora.uf());
        Jogo jogo = new Jogo();
        jogo.setTimeCasa(time1);
        jogo.setTimeFora(time2);
        jogo.setRodada(rodada);
        jogo.setData(dataJogo);
        jogo.setEncerrado(false);
        jogo.setGolsTimeCasa(0);
        jogo.setGolsTimeFora(0);
        jogo.setPublicoPagante(0.0);
        return jogo;
    }
}
