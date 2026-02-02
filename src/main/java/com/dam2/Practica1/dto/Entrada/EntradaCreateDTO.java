package com.dam2.Practica1.dto.Entrada;

import com.dam2.Practica1.model.Entrada.EstadoEntrada;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaCreateDTO {
    private String codigo;
    @NotNull(message = "La fila es obligatoria")
    private int fila;
    @NotNull(message = "El asiento es obligatorio")
    private int asiento;
    private EstadoEntrada estado;
    @NotNull(message = "El ID de la venta es obligatorio")
    private long ventaId;
    @NotNull(message = "El ID de la función es obligatorio")
    private long funcionId;
}
