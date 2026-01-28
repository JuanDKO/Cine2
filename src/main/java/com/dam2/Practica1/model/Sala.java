package com.dam2.Practica1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "salas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private int capacidad;

    @OneToMany(mappedBy = "sala")
    private List<Funcion> funciones;
}
