package com.dam2.Practica1.mapper;

import com.dam2.Practica1.dto.Actor.ActorCreateDTO;
import com.dam2.Practica1.dto.Actor.ActorDTO;
import com.dam2.Practica1.model.Actor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-28T12:06:41+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24 (Oracle Corporation)"
)
@Component
public class ActorMapperImpl implements ActorMapper {

    @Override
    public ActorDTO toDTO(Actor actor) {
        if ( actor == null ) {
            return null;
        }

        ActorDTO actorDTO = new ActorDTO();

        actorDTO.setId( actor.getId() );
        actorDTO.setNombre( actor.getNombre() );

        return actorDTO;
    }

    @Override
    public Actor fromCreateUpdateDTO(ActorCreateDTO actorCreateDTO) {
        if ( actorCreateDTO == null ) {
            return null;
        }

        Actor actor = new Actor();

        actor.setNombre( actorCreateDTO.getNombre() );

        return actor;
    }

    @Override
    public void updateEntityFromDTO(ActorCreateDTO actorCreateDTO, Actor actor) {
        if ( actorCreateDTO == null ) {
            return;
        }

        actor.setNombre( actorCreateDTO.getNombre() );
    }

    @Override
    public List<ActorDTO> toDTO(List<Actor> actors) {
        if ( actors == null ) {
            return null;
        }

        List<ActorDTO> list = new ArrayList<ActorDTO>( actors.size() );
        for ( Actor actor : actors ) {
            list.add( toDTO( actor ) );
        }

        return list;
    }
}
