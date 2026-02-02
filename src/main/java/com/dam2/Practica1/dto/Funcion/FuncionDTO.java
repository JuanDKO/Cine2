package com.dam2.Practica1.dto.Funcion;

import com.dam2.Practica1.dto.Pelicula.PeliculaDTO;
import com.dam2.Practica1.dto.Sala.SalaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionDTO {
    private long id;
    private LocalDateTime fechaHora;
    private double precio;
    private PeliculaDTO pelicula;

    @JsonIgnoreProperties("funciones")
    private SalaDTO sala;
}
