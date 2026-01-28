package com.dam2.Practica1.mapper;

import com.dam2.Practica1.model.Venta;
import com.dam2.Practica1.dto.Venta.VentaCreateDTO;
import com.dam2.Practica1.dto.Venta.VentaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = { UsuarioMapper.class })
public interface VentaMapper {
    VentaMapper INSTANCE = Mappers.getMapper(VentaMapper.class);

    VentaDTO toDTO(Venta venta);

    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "entradas", ignore = true)
    Venta fromCreateUpdateDTO(VentaCreateDTO ventaCreateDTO);

    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "entradas", ignore = true)
    void updateEntityFromDTO(VentaCreateDTO ventaCreateDTO, @MappingTarget Venta venta);

    List<VentaDTO> toDTO(List<Venta> ventas);
}
