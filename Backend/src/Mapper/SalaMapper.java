package Mapper;

import Clase.Sala;
import DTOs.Sala.SalaCreateDTO;
import DTOs.Sala.SalaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = { FuncionMapper.class })
public interface SalaMapper {
    SalaMapper INSTANCE = Mappers.getMapper(SalaMapper.class);

    SalaDTO toDTO(Sala sala);

    @Mapping(target = "funciones", ignore = true)
    Sala fromCreateUpdateDTO(SalaCreateDTO salaCreateDTO);

    @Mapping(target = "funciones", ignore = true)
    void updateEntityFromDTO(SalaCreateDTO salaCreateDTO, @MappingTarget Sala sala);

    List<SalaDTO> toDTO(List<Sala> salas);
}
