package com.dam2.Practica1.dto.Venta;

import com.dam2.Practica1.dto.Usuario.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {
    private long id;
    private LocalDateTime fecha;
    private double importeTotal;
    private String metodoPago;
    private String estado;

    @JsonIgnoreProperties("ventas")
    private UsuarioDTO usuario;
}
