package com.dam2.Practica1.dto.Sala;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaCreateDTO {
    private String nombre;
    private int capacidad;
    private List<Long> funcionesId;
}
