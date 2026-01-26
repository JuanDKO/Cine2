package Mapper;

import Clase.Entrada;
import DTOs.Entrada.EntradaCreateDTO;
import DTOs.Entrada.EntradaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = { VentaMapper.class, FuncionMapper.class })
public interface EntradaMapper {
    EntradaMapper INSTANCE = Mappers.getMapper(EntradaMapper.class);

    EntradaDTO toDTO(Entrada entrada);

    @Mapping(target = "venta", ignore = true)
    @Mapping(target = "funcion", ignore = true)
    Entrada fromCreateUpdateDTO(EntradaCreateDTO entradaCreateDTO);

    @Mapping(target = "venta", ignore = true)
    @Mapping(target = "funcion", ignore = true)
    void updateEntityFromDTO(EntradaCreateDTO entradaCreateDTO, @MappingTarget Entrada entrada);

    List<EntradaDTO> toDTO(List<Entrada> entradas);
}
