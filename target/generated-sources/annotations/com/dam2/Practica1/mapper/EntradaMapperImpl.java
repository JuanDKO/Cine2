package com.dam2.Practica1.mapper;

import com.dam2.Practica1.dto.Entrada.EntradaCreateDTO;
import com.dam2.Practica1.dto.Entrada.EntradaDTO;
import com.dam2.Practica1.model.Entrada;
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
public class EntradaMapperImpl implements EntradaMapper {

    @Autowired
    private VentaMapper ventaMapper;
    @Autowired
    private FuncionMapper funcionMapper;

    @Override
    public EntradaDTO toDTO(Entrada entrada) {
        if ( entrada == null ) {
            return null;
        }

        EntradaDTO entradaDTO = new EntradaDTO();

        entradaDTO.setId( entrada.getId() );
        entradaDTO.setCodigo( entrada.getCodigo() );
        entradaDTO.setFila( entrada.getFila() );
        entradaDTO.setAsiento( entrada.getAsiento() );
        entradaDTO.setEstadoEntrada( entrada.getEstadoEntrada() );
        entradaDTO.setVenta( ventaMapper.toDTO( entrada.getVenta() ) );
        entradaDTO.setFuncion( funcionMapper.toDTO( entrada.getFuncion() ) );

        return entradaDTO;
    }

    @Override
    public Entrada fromCreateUpdateDTO(EntradaCreateDTO entradaCreateDTO) {
        if ( entradaCreateDTO == null ) {
            return null;
        }

        Entrada entrada = new Entrada();

        entrada.setCodigo( entradaCreateDTO.getCodigo() );
        entrada.setFila( entradaCreateDTO.getFila() );
        entrada.setAsiento( entradaCreateDTO.getAsiento() );
        entrada.setEstadoEntrada( entradaCreateDTO.getEstadoEntrada() );

        return entrada;
    }

    @Override
    public void updateEntityFromDTO(EntradaCreateDTO entradaCreateDTO, Entrada entrada) {
        if ( entradaCreateDTO == null ) {
            return;
        }

        entrada.setCodigo( entradaCreateDTO.getCodigo() );
        entrada.setFila( entradaCreateDTO.getFila() );
        entrada.setAsiento( entradaCreateDTO.getAsiento() );
        entrada.setEstadoEntrada( entradaCreateDTO.getEstadoEntrada() );
    }

    @Override
    public List<EntradaDTO> toDTO(List<Entrada> entradas) {
        if ( entradas == null ) {
            return null;
        }

        List<EntradaDTO> list = new ArrayList<EntradaDTO>( entradas.size() );
        for ( Entrada entrada : entradas ) {
            list.add( toDTO( entrada ) );
        }

        return list;
    }
}
