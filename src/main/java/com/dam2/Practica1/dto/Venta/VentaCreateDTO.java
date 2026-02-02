package com.dam2.Practica1.dto.Venta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaCreateDTO {
    @NotNull(message = "La fecha es obligatoria")
    private LocalDateTime fecha;
    @NotNull(message = "El importe total es obligatorio")
    private double importeTotal;
    @NotNull(message = "El método de paho es obligatorio")
    private String metodoPago;
    private String estado;
    @NotNull(message = "El ID del usuario es obligatorio")
    private long usuarioId;
}
