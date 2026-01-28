package com.dam2.Practica1.dto.Funcion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionCreateDTO {
    @NotNull(message = "La fecha y hora son obligatorias")
    private LocalDate fechaHora;
    @NotNull(message = "El precio es obligatorio")
    private double precio;
    @NotNull(message = "El ID de la película es obligatorio")
    private long peliculaId;
    @NotNull(message = "El ID de la sala es obligatorio")
    private long salaId;
}
