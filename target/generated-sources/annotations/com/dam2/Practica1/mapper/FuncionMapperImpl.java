package com.dam2.Practica1.mapper;

import com.dam2.Practica1.dto.Funcion.FuncionCreateDTO;
import com.dam2.Practica1.dto.Funcion.FuncionDTO;
import com.dam2.Practica1.model.Funcion;
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
public class FuncionMapperImpl implements FuncionMapper {

    @Autowired
    private PeliculaMapper peliculaMapper;
    @Autowired
    private SalaMapper salaMapper;

    @Override
    public FuncionDTO toDTO(Funcion funcion) {
        if ( funcion == null ) {
            return null;
        }

        FuncionDTO funcionDTO = new FuncionDTO();

        funcionDTO.setId( funcion.getId() );
        funcionDTO.setFechaHora( funcion.getFechaHora() );
        funcionDTO.setPrecio( funcion.getPrecio() );
        funcionDTO.setPelicula( peliculaMapper.toDTO( funcion.getPelicula() ) );
        funcionDTO.setSala( salaMapper.toDTO( funcion.getSala() ) );

        return funcionDTO;
    }

    @Override
    public Funcion fromCreateUpdateDTO(FuncionCreateDTO funcionCreateDTO) {
        if ( funcionCreateDTO == null ) {
            return null;
        }

        Funcion funcion = new Funcion();

        funcion.setFechaHora( funcionCreateDTO.getFechaHora() );
        funcion.setPrecio( funcionCreateDTO.getPrecio() );

        return funcion;
    }

    @Override
    public void updateEntityFromDTO(FuncionCreateDTO funcionCreateDTO, Funcion funcion) {
        if ( funcionCreateDTO == null ) {
            return;
        }

        funcion.setFechaHora( funcionCreateDTO.getFechaHora() );
        funcion.setPrecio( funcionCreateDTO.getPrecio() );
    }

    @Override
    public List<FuncionDTO> toDTO(List<Funcion> funciones) {
        if ( funciones == null ) {
            return null;
        }

        List<FuncionDTO> list = new ArrayList<FuncionDTO>( funciones.size() );
        for ( Funcion funcion : funciones ) {
            list.add( toDTO( funcion ) );
        }

        return list;
    }
}
