package com.dam2.Practica1.mapper;

import com.dam2.Practica1.dto.Pelicula.PeliculaCreateDTO;
import com.dam2.Practica1.dto.Pelicula.PeliculaDTO;
import com.dam2.Practica1.model.Pelicula;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-28T12:06:42+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24 (Oracle Corporation)"
)
@Component
public class PeliculaMapperImpl implements PeliculaMapper {

    @Autowired
    private DirectorMapper directorMapper;

    @Override
    public PeliculaDTO toDTO(Pelicula pelicula) {
        if ( pelicula == null ) {
            return null;
        }

        PeliculaDTO peliculaDTO = new PeliculaDTO();

        peliculaDTO.setId( pelicula.getId() );
        peliculaDTO.setNombre( pelicula.getNombre() );
        peliculaDTO.setDuracion( pelicula.getDuracion() );
        peliculaDTO.setEdadMinima( pelicula.getEdadMinima() );
        peliculaDTO.setDirector( directorMapper.toDTO( pelicula.getDirector() ) );

        return peliculaDTO;
    }

    @Override
    public Pelicula fromCreateUpdateDTO(PeliculaCreateDTO peliculaCreateDTO) {
        if ( peliculaCreateDTO == null ) {
            return null;
        }

        Pelicula pelicula = new Pelicula();

        pelicula.setNombre( peliculaCreateDTO.getNombre() );
        pelicula.setDuracion( peliculaCreateDTO.getDuracion() );
        pelicula.setEdadMinima( peliculaCreateDTO.getEdadMinima() );

        return pelicula;
    }

    @Override
    public void updateEntityFromDTO(PeliculaCreateDTO peliculaCreateDTO, Pelicula pelicula) {
        if ( peliculaCreateDTO == null ) {
            return;
        }

        pelicula.setNombre( peliculaCreateDTO.getNombre() );
        pelicula.setDuracion( peliculaCreateDTO.getDuracion() );
        pelicula.setEdadMinima( peliculaCreateDTO.getEdadMinima() );
    }

    @Override
    public List<PeliculaDTO> toDTO(List<Pelicula> peliculas) {
        if ( peliculas == null ) {
            return null;
        }

        List<PeliculaDTO> list = new ArrayList<PeliculaDTO>( peliculas.size() );
        for ( Pelicula pelicula : peliculas ) {
            list.add( toDTO( pelicula ) );
        }

        return list;
    }
}
