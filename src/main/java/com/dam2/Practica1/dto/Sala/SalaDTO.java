package com.dam2.Practica1.dto.Sala;

import com.dam2.Practica1.dto.Funcion.FuncionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaDTO {
    private long id;
    private String nombre;
    private int capacidad;

    @JsonIgnoreProperties("sala")
    private List<FuncionDTO> funciones;
}
