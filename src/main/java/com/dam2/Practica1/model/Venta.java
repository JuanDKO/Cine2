package com.dam2.Practica1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ventas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate fecha;
    @Column(name = "importe_total")
    private double importeTotal;
    @Column(name = "metodo_pago")
    private String metodoPago;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "usuarioId", nullable = false)
    private Usuario usuario;

    // Entradas compradas en la venta
    @OneToMany(mappedBy = "venta")
    private List<Entrada> entradas;
}
