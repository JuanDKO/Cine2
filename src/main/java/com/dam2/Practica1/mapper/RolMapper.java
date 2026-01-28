package com.dam2.Practica1.mapper;

import com.dam2.Practica1.model.Rol;
import com.dam2.Practica1.dto.Rol.RolCreateDTO;
import com.dam2.Practica1.dto.Rol.RolDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolMapper {
    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    RolDTO toDTO(Rol rol);

    Rol fromCreateUpdateDTO(RolCreateDTO rolCreateDTO);

    void updateEntityFromDTO(RolCreateDTO rolCreateDTO, @MappingTarget Rol rol);

    List<RolDTO> toDTO(List<Rol> roles);
}
