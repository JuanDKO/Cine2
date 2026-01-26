package Mapper;

import Clase.Director;
import DTOs.Director.DirectorCreateDTO;
import DTOs.Director.DirectorDTO;
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
