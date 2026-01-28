package com.dam2.Practica1.mapper;

import com.dam2.Practica1.model.Sala;
import com.dam2.Practica1.dto.Sala.SalaCreateDTO;
import com.dam2.Practica1.dto.Sala.SalaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalaMapper {
    SalaMapper INSTANCE = Mappers.getMapper(SalaMapper.class);

    @Mapping(target = "funciones", qualifiedByName = "toFuncionDTO")
    SalaDTO toDTO(Sala sala);

    @Mapping(target = "funciones", ignore = true)
    Sala fromCreateUpdateDTO(SalaCreateDTO salaCreateDTO);

    @Mapping(target = "funciones", ignore = true)
    void updateEntityFromDTO(SalaCreateDTO salaCreateDTO, @MappingTarget Sala sala);

    List<SalaDTO> toDTO(List<Sala> salas);

    @org.mapstruct.Named("toFuncionDTO")
    @Mapping(target = "sala", ignore = true)
    com.dam2.Practica1.dto.Funcion.FuncionDTO toFuncionDTO(com.dam2.Practica1.model.Funcion funcion);
}
