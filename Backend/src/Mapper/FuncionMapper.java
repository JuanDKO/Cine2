package Mapper;

import Clase.Funcion;
import DTOs.Funcion.FuncionCreateDTO;
import DTOs.Funcion.FuncionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = { PeliculaMapper.class, SalaMapper.class })
public interface FuncionMapper {
    FuncionMapper INSTANCE = Mappers.getMapper(FuncionMapper.class);

    FuncionDTO toDTO(Funcion funcion);

    @Mapping(target = "pelicula", ignore = true)
    @Mapping(target = "sala", ignore = true)
    @Mapping(target = "entradas", ignore = true)
    Funcion fromCreateUpdateDTO(FuncionCreateDTO funcionCreateDTO);

    @Mapping(target = "pelicula", ignore = true)
    @Mapping(target = "sala", ignore = true)
    @Mapping(target = "entradas", ignore = true)
    void updateEntityFromDTO(FuncionCreateDTO funcionCreateDTO, @MappingTarget Funcion funcion);

    List<FuncionDTO> toDTO(List<Funcion> funciones);
}
