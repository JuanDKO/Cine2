package com.dam2.Practica1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "entradas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codigo;
    private int fila;
    private int asiento;
    @Enumerated(EnumType.STRING)
    private EstadoEntrada estado;

    @ManyToOne
    @JoinColumn(name = "ventaId", nullable = false)
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "funcionId", nullable = false)
    private Funcion funcion;

    public enum EstadoEntrada {
        ACTIVA,
        USADA,
        CANCELADA
    }
}
