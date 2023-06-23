package com.jan1ooo.cbf.campeonatobrasileiro.service;

import com.jan1ooo.cbf.campeonatobrasileiro.DTO.TimeDTO;
import com.jan1ooo.cbf.campeonatobrasileiro.DTO.mapper.TimeMapper;
import com.jan1ooo.cbf.campeonatobrasileiro.repository.TimeRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeService {
    @Autowired
    public final TimeRepository repository;
    public final TimeMapper timeMapper;

    public TimeService(TimeRepository repository, TimeMapper timeMapper) {
        this.repository = repository;
        this.timeMapper = timeMapper;
    }

    public List<TimeDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(timeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TimeDTO findById(@NotNull @Positive Long id) {
        return repository.findById(id)
                .map(timeMapper::toDTO)
                .orElseThrow(() -> new RuntimeException());
    }

    public TimeDTO save(@Valid @NotNull TimeDTO time) {
        return timeMapper.toDTO(repository.save(timeMapper.toEntity(time)));
    }
}
