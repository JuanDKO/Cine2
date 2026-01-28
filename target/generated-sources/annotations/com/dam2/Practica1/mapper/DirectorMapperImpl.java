package com.dam2.Practica1.mapper;

import com.dam2.Practica1.dto.Director.DirectorCreateDTO;
import com.dam2.Practica1.dto.Director.DirectorDTO;
import com.dam2.Practica1.model.Director;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-28T12:06:42+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24 (Oracle Corporation)"
)
@Component
public class DirectorMapperImpl implements DirectorMapper {

    @Override
    public DirectorDTO toDTO(Director director) {
        if ( director == null ) {
            return null;
        }

        DirectorDTO directorDTO = new DirectorDTO();

        directorDTO.setId( director.getId() );
        directorDTO.setNombre( director.getNombre() );

        return directorDTO;
    }

    @Override
    public Director fromCreateUpdateDTO(DirectorCreateDTO directorCreateDTO) {
        if ( directorCreateDTO == null ) {
            return null;
        }

        Director director = new Director();

        director.setNombre( directorCreateDTO.getNombre() );

        return director;
    }

    @Override
    public void updateEntityFromDTO(DirectorCreateDTO directorCreateDTO, Director director) {
        if ( directorCreateDTO == null ) {
            return;
        }

        director.setNombre( directorCreateDTO.getNombre() );
    }

    @Override
    public List<DirectorDTO> toDTO(List<Director> directors) {
        if ( directors == null ) {
            return null;
        }

        List<DirectorDTO> list = new ArrayList<DirectorDTO>( directors.size() );
        for ( Director director : directors ) {
            list.add( toDTO( director ) );
        }

        return list;
    }
}
