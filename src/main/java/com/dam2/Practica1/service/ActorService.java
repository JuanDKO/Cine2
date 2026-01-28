package com.dam2.Practica1.service;

import com.dam2.Practica1.model.Actor;
import com.dam2.Practica1.dto.Actor.ActorCreateDTO;
import com.dam2.Practica1.dto.Actor.ActorDTO;
import com.dam2.Practica1.mapper.ActorMapper;
import com.dam2.Practica1.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ActorMapper actorMapper;

    public List<ActorDTO> getAllActors() {
        return actorMapper.toDTO(actorRepository.findAll());
    }

    public Optional<ActorDTO> getActorById(Long id) {
        return actorRepository.findById(id).map(actorMapper::toDTO);
    }

    public ActorDTO createActor(ActorCreateDTO actorCreateDTO) {
        Actor actor = actorMapper.fromCreateUpdateDTO(actorCreateDTO);
        return actorMapper.toDTO(actorRepository.save(actor));
    }

    public Optional<ActorDTO> updateActor(Long id, ActorCreateDTO actorCreateDTO) {
        return actorRepository.findById(id).map(actor -> {
            actorMapper.updateEntityFromDTO(actorCreateDTO, actor);
            return actorMapper.toDTO(actorRepository.save(actor));
        });
    }

    public boolean deleteActor(Long id) {
        if (actorRepository.existsById(id)) {
            actorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
