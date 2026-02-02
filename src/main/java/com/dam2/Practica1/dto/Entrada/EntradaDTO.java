package com.dam2.Practica1.dto.Entrada;

import com.dam2.Practica1.dto.Funcion.FuncionDTO;
import com.dam2.Practica1.dto.Venta.VentaDTO;
import com.dam2.Practica1.model.EstadoEntrada;
import com.dam2.Practica1.model.Venta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaDTO {
    private long id;
    private String codigo;
    private int fila;
    private int asiento;
    private EstadoEntrada estado;
    private VentaDTO venta;
    private FuncionDTO funcion;
}
