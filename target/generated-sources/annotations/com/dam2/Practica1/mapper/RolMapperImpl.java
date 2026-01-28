package com.dam2.Practica1.mapper;

import com.dam2.Practica1.dto.Rol.RolCreateDTO;
import com.dam2.Practica1.dto.Rol.RolDTO;
import com.dam2.Practica1.model.Rol;
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
public class RolMapperImpl implements RolMapper {

    @Override
    public RolDTO toDTO(Rol rol) {
        if ( rol == null ) {
            return null;
        }

        RolDTO rolDTO = new RolDTO();

        rolDTO.setId( rol.getId() );
        rolDTO.setNombre( rol.getNombre() );

        return rolDTO;
    }

    @Override
    public Rol fromCreateUpdateDTO(RolCreateDTO rolCreateDTO) {
        if ( rolCreateDTO == null ) {
            return null;
        }

        Rol rol = new Rol();

        rol.setNombre( rolCreateDTO.getNombre() );

        return rol;
    }

    @Override
    public void updateEntityFromDTO(RolCreateDTO rolCreateDTO, Rol rol) {
        if ( rolCreateDTO == null ) {
            return;
        }

        rol.setNombre( rolCreateDTO.getNombre() );
    }

    @Override
    public List<RolDTO> toDTO(List<Rol> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RolDTO> list = new ArrayList<RolDTO>( roles.size() );
        for ( Rol rol : roles ) {
            list.add( toDTO( rol ) );
        }

        return list;
    }
}
