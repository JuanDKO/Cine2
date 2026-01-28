package com.dam2.Practica1.mapper;

import com.dam2.Practica1.model.Pelicula;
import com.dam2.Practica1.dto.Pelicula.PeliculaCreateDTO;
import com.dam2.Practica1.dto.Pelicula.PeliculaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = { DirectorMapper.class })
public interface PeliculaMapper {
    PeliculaMapper INSTANCE = Mappers.getMapper(PeliculaMapper.class);

    PeliculaDTO toDTO(Pelicula pelicula);

    @Mapping(target = "director", ignore = true)
    @Mapping(target = "actores", ignore = true)
    @Mapping(target = "funciones", ignore = true)
    Pelicula fromCreateUpdateDTO(PeliculaCreateDTO peliculaCreateDTO);

    @Mapping(target = "director", ignore = true)
    @Mapping(target = "actores", ignore = true)
    @Mapping(target = "funciones", ignore = true)
    void updateEntityFromDTO(PeliculaCreateDTO peliculaCreateDTO, @MappingTarget Pelicula pelicula);

    List<PeliculaDTO> toDTO(List<Pelicula> peliculas);
}
