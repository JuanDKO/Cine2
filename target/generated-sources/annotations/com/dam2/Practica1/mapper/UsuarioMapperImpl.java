package com.dam2.Practica1.mapper;

import com.dam2.Practica1.dto.Usuario.UsuarioCreateDTO;
import com.dam2.Practica1.dto.Usuario.UsuarioDTO;
import com.dam2.Practica1.dto.Venta.VentaDTO;
import com.dam2.Practica1.model.Usuario;
import com.dam2.Practica1.model.Venta;
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
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDTO toDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setVentas( ventaListToVentaDTOList( usuario.getVentas() ) );
        usuarioDTO.setId( usuario.getId() );
        usuarioDTO.setEmail( usuario.getEmail() );
        usuarioDTO.setEnabled( usuario.isEnabled() );

        return usuarioDTO;
    }

    @Override
    public Usuario fromCreateUpdateDTO(UsuarioCreateDTO usuarioCreateDTO) {
        if ( usuarioCreateDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setEmail( usuarioCreateDTO.getEmail() );
        usuario.setPassword( usuarioCreateDTO.getPassword() );
        usuario.setEnabled( usuarioCreateDTO.isEnabled() );

        return usuario;
    }

    @Override
    public void updateEntityFromDTO(UsuarioCreateDTO usuarioCreateDTO, Usuario usuario) {
        if ( usuarioCreateDTO == null ) {
            return;
        }

        usuario.setEmail( usuarioCreateDTO.getEmail() );
        usuario.setPassword( usuarioCreateDTO.getPassword() );
        usuario.setEnabled( usuarioCreateDTO.isEnabled() );
    }

    @Override
    public List<UsuarioDTO> toDTO(List<Usuario> usuarios) {
        if ( usuarios == null ) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>( usuarios.size() );
        for ( Usuario usuario : usuarios ) {
            list.add( toDTO( usuario ) );
        }

        return list;
    }

    @Override
    public VentaDTO toVentaDTO(Venta venta) {
        if ( venta == null ) {
            return null;
        }

        VentaDTO ventaDTO = new VentaDTO();

        ventaDTO.setId( venta.getId() );
        ventaDTO.setFecha( venta.getFecha() );
        ventaDTO.setImporteTotal( venta.getImporteTotal() );
        ventaDTO.setMetodoPago( venta.getMetodoPago() );
        ventaDTO.setEstado( venta.getEstado() );

        return ventaDTO;
    }

    protected List<VentaDTO> ventaListToVentaDTOList(List<Venta> list) {
        if ( list == null ) {
            return null;
        }

        List<VentaDTO> list1 = new ArrayList<VentaDTO>( list.size() );
        for ( Venta venta : list ) {
            list1.add( toVentaDTO( venta ) );
        }

        return list1;
    }
}
