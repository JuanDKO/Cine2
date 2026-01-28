package com.dam2.Practica1.mapper;

import com.dam2.Practica1.dto.Director.DirectorDTO;
import com.dam2.Practica1.dto.Funcion.FuncionDTO;
import com.dam2.Practica1.dto.Pelicula.PeliculaDTO;
import com.dam2.Practica1.dto.Sala.SalaCreateDTO;
import com.dam2.Practica1.dto.Sala.SalaDTO;
import com.dam2.Practica1.model.Director;
import com.dam2.Practica1.model.Funcion;
import com.dam2.Practica1.model.Pelicula;
import com.dam2.Practica1.model.Sala;
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
public class SalaMapperImpl implements SalaMapper {

    @Override
    public SalaDTO toDTO(Sala sala) {
        if ( sala == null ) {
            return null;
        }

        SalaDTO salaDTO = new SalaDTO();

        salaDTO.setFunciones( funcionListToFuncionDTOList( sala.getFunciones() ) );
        salaDTO.setId( sala.getId() );
        salaDTO.setNombre( sala.getNombre() );
        salaDTO.setCapacidad( sala.getCapacidad() );

        return salaDTO;
    }

    @Override
    public Sala fromCreateUpdateDTO(SalaCreateDTO salaCreateDTO) {
        if ( salaCreateDTO == null ) {
            return null;
        }

        Sala sala = new Sala();

        sala.setNombre( salaCreateDTO.getNombre() );
        sala.setCapacidad( salaCreateDTO.getCapacidad() );

        return sala;
    }

    @Override
    public void updateEntityFromDTO(SalaCreateDTO salaCreateDTO, Sala sala) {
        if ( salaCreateDTO == null ) {
            return;
        }

        sala.setNombre( salaCreateDTO.getNombre() );
        sala.setCapacidad( salaCreateDTO.getCapacidad() );
    }

    @Override
    public List<SalaDTO> toDTO(List<Sala> salas) {
        if ( salas == null ) {
            return null;
        }

        List<SalaDTO> list = new ArrayList<SalaDTO>( salas.size() );
        for ( Sala sala : salas ) {
            list.add( toDTO( sala ) );
        }

        return list;
    }

    @Override
    public FuncionDTO toFuncionDTO(Funcion funcion) {
        if ( funcion == null ) {
            return null;
        }

        FuncionDTO funcionDTO = new FuncionDTO();

        funcionDTO.setId( funcion.getId() );
        funcionDTO.setFechaHora( funcion.getFechaHora() );
        funcionDTO.setPrecio( funcion.getPrecio() );
        funcionDTO.setPelicula( peliculaToPeliculaDTO( funcion.getPelicula() ) );

        return funcionDTO;
    }

    protected List<FuncionDTO> funcionListToFuncionDTOList(List<Funcion> list) {
        if ( list == null ) {
            return null;
        }

        List<FuncionDTO> list1 = new ArrayList<FuncionDTO>( list.size() );
        for ( Funcion funcion : list ) {
            list1.add( toFuncionDTO( funcion ) );
        }

        return list1;
    }

    protected DirectorDTO directorToDirectorDTO(Director director) {
        if ( director == null ) {
            return null;
        }

        DirectorDTO directorDTO = new DirectorDTO();

        directorDTO.setId( director.getId() );
        directorDTO.setNombre( director.getNombre() );

        return directorDTO;
    }

    protected PeliculaDTO peliculaToPeliculaDTO(Pelicula pelicula) {
        if ( pelicula == null ) {
            return null;
        }

        PeliculaDTO peliculaDTO = new PeliculaDTO();

        peliculaDTO.setId( pelicula.getId() );
        peliculaDTO.setNombre( pelicula.getNombre() );
        peliculaDTO.setDuracion( pelicula.getDuracion() );
        peliculaDTO.setEdadMinima( pelicula.getEdadMinima() );
        peliculaDTO.setDirector( directorToDirectorDTO( pelicula.getDirector() ) );

        return peliculaDTO;
    }
}
