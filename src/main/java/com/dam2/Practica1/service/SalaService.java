package com.dam2.Practica1.service;

import com.dam2.Practica1.model.Sala;
import com.dam2.Practica1.dto.Sala.SalaCreateDTO;
import com.dam2.Practica1.dto.Sala.SalaDTO;
import com.dam2.Practica1.mapper.SalaMapper;
import com.dam2.Practica1.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private SalaMapper salaMapper;

    public List<SalaDTO> getAllSalas() {
        return salaMapper.toDTO(salaRepository.findAll());
    }

    public Optional<SalaDTO> getSalaById(Long id) {
        return salaRepository.findById(id).map(salaMapper::toDTO);
    }

    public SalaDTO createSala(SalaCreateDTO salaCreateDTO) {
        Sala sala = salaMapper.fromCreateUpdateDTO(salaCreateDTO);
        return salaMapper.toDTO(salaRepository.save(sala));
    }

    public Optional<SalaDTO> updateSala(Long id, SalaCreateDTO salaCreateDTO) {
        return salaRepository.findById(id).map(sala -> {
            salaMapper.updateEntityFromDTO(salaCreateDTO, sala);
            return salaMapper.toDTO(salaRepository.save(sala));
        });
    }

    public boolean deleteSala(Long id) {
        if (salaRepository.existsById(id)) {
            salaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
