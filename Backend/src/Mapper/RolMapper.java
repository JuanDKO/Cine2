package Mapper;

import Clase.Rol;
import DTOs.Rol.RolCreateDTO;
import DTOs.Rol.RolDTO;
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
