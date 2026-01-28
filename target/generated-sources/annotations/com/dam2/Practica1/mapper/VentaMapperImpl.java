package com.dam2.Practica1.mapper;

import com.dam2.Practica1.dto.Venta.VentaCreateDTO;
import com.dam2.Practica1.dto.Venta.VentaDTO;
import com.dam2.Practica1.model.Venta;
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
public class VentaMapperImpl implements VentaMapper {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public VentaDTO toDTO(Venta venta) {
        if ( venta == null ) {
            return null;
        }

        VentaDTO ventaDTO = new VentaDTO();

        ventaDTO.setId( venta.getId() );
        ventaDTO.setFecha( venta.getFecha() );
        ventaDTO.setImporteTotal( venta.getImporteTotal() );
        ventaDTO.setMetodoPago( venta.getMetodoPago() );
        ventaDTO.setEstado( venta.getEstado() );
        ventaDTO.setUsuario( usuarioMapper.toDTO( venta.getUsuario() ) );

        return ventaDTO;
    }

    @Override
    public Venta fromCreateUpdateDTO(VentaCreateDTO ventaCreateDTO) {
        if ( ventaCreateDTO == null ) {
            return null;
        }

        Venta venta = new Venta();

        venta.setFecha( ventaCreateDTO.getFecha() );
        venta.setImporteTotal( ventaCreateDTO.getImporteTotal() );
        venta.setMetodoPago( ventaCreateDTO.getMetodoPago() );
        venta.setEstado( ventaCreateDTO.getEstado() );

        return venta;
    }

    @Override
    public void updateEntityFromDTO(VentaCreateDTO ventaCreateDTO, Venta venta) {
        if ( ventaCreateDTO == null ) {
            return;
        }

        venta.setFecha( ventaCreateDTO.getFecha() );
        venta.setImporteTotal( ventaCreateDTO.getImporteTotal() );
        venta.setMetodoPago( ventaCreateDTO.getMetodoPago() );
        venta.setEstado( ventaCreateDTO.getEstado() );
    }

    @Override
    public List<VentaDTO> toDTO(List<Venta> ventas) {
        if ( ventas == null ) {
            return null;
        }

        List<VentaDTO> list = new ArrayList<VentaDTO>( ventas.size() );
        for ( Venta venta : ventas ) {
            list.add( toDTO( venta ) );
        }

        return list;
    }
}
