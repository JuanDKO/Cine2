package com.dam2.Practica1.mapper;

import com.dam2.Practica1.model.Usuario;
import com.dam2.Practica1.dto.Usuario.UsuarioCreateDTO;
import com.dam2.Practica1.dto.Usuario.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(target = "ventas", qualifiedByName = "toVentaDTO")
    UsuarioDTO toDTO(Usuario usuario);

    @Mapping(target = "ventas", ignore = true)
    Usuario fromCreateUpdateDTO(UsuarioCreateDTO usuarioCreateDTO);

    @Mapping(target = "ventas", ignore = true)
    void updateEntityFromDTO(UsuarioCreateDTO usuarioCreateDTO, @MappingTarget Usuario usuario);

    List<UsuarioDTO> toDTO(List<Usuario> usuarios);

    @org.mapstruct.Named("toVentaDTO")
    @Mapping(target = "usuario", ignore = true)
    com.dam2.Practica1.dto.Venta.VentaDTO toVentaDTO(com.dam2.Practica1.model.Venta venta);
}
