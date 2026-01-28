package com.dam2.Practica1.dto.Entrada;

import com.dam2.Practica1.dto.Funcion.FuncionDTO;
import com.dam2.Practica1.dto.Venta.VentaDTO;
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
    private String estadoEntrada;
    private VentaDTO venta;
    private FuncionDTO funcion;
}
