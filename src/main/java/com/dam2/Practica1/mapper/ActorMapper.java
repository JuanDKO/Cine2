package com.dam2.Practica1.mapper;

import com.dam2.Practica1.model.Actor;
import com.dam2.Practica1.dto.Actor.ActorCreateDTO;
import com.dam2.Practica1.dto.Actor.ActorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {
    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

    ActorDTO toDTO(Actor actor);

    Actor fromCreateUpdateDTO(ActorCreateDTO actorCreateDTO);

    void updateEntityFromDTO(ActorCreateDTO actorCreateDTO, @MappingTarget Actor actor);

    List<ActorDTO> toDTO(List<Actor> actors);
}
