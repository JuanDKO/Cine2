package com.dam2.Practica1.mapper;

import com.dam2.Practica1.model.Director;
import com.dam2.Practica1.dto.Director.DirectorCreateDTO;
import com.dam2.Practica1.dto.Director.DirectorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DirectorMapper {
    DirectorMapper INSTANCE = Mappers.getMapper(DirectorMapper.class);

    DirectorDTO toDTO(Director director);

    Director fromCreateUpdateDTO(DirectorCreateDTO directorCreateDTO);

    void updateEntityFromDTO(DirectorCreateDTO directorCreateDTO, @MappingTarget Director director);

    List<DirectorDTO> toDTO(List<Director> directors);
}
