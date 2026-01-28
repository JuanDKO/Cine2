package com.dam2.Practica1.model;

import com.dam2.Practica1.model.Pelicula;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "directores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    @OneToMany(mappedBy = "director")
    private List<Pelicula> peliculas;

}
