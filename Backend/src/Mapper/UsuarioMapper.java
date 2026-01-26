package Mapper;

import Clase.Usuario;
import DTOs.Usuario.UsuarioCreateDTO;
import DTOs.Usuario.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = { VentaMapper.class })
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO toDTO(Usuario usuario);

    @Mapping(target = "ventas", ignore = true)
    Usuario fromCreateUpdateDTO(UsuarioCreateDTO usuarioCreateDTO);

    @Mapping(target = "ventas", ignore = true)
    void updateEntityFromDTO(UsuarioCreateDTO usuarioCreateDTO, @MappingTarget Usuario usuario);

    List<UsuarioDTO> toDTO(List<Usuario> usuarios);
}
