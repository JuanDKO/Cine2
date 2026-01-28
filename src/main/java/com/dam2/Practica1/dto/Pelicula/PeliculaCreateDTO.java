package com.dam2.Practica1.dto.Pelicula;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaCreateDTO {
    @NotBlank(message = "El nombre de la película es obligatorio")
    private String nombre;
    @NotNull(message = "La duración es obligatoria")
    private int duracion;
    private int edadMinima;
    @NotNull(message = "El ID del director es obligatorio")
    private long directorId;
}
