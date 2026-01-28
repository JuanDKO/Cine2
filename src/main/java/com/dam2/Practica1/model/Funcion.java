package com.dam2.Practica1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "funciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "fecha_hora")
    private LocalDate fechaHora;

    private double precio;

    @ManyToOne
    @JoinColumn(name = "peliculaId", nullable = false)
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "salaId", nullable = false)
    private Sala sala;

    @OneToMany(mappedBy = "funcion")
    private List<Entrada> entradas;

}
