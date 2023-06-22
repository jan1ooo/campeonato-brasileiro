package com.jan1ooo.cbf.campeonatobrasileiro.service;

import com.jan1ooo.cbf.campeonatobrasileiro.entity.Time;
import com.jan1ooo.cbf.campeonatobrasileiro.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {

    @Autowired
    public TimeRepository repository;

    public Time cadastrarTime(Time time) {
        return repository.save(time);
    }

    public List<Time> listarTimes() {
        return repository.findAll();
    }
}
