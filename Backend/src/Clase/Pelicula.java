package Clase;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

@Entity
@Table(name = "peliculas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private int duracion;

    @Column(name = "edad_minima")
    private int edadMinima;

    @ManyToOne
    @JoinColumn(name = "directorId", nullable = false)
    @JsonManagedReference
    private Director director;

    @ManyToMany(mappedBy = "peliculas")
    private List<Actor> actores;

    @OneToMany(mappedBy = "peliculas")
    private List<Funcion> funciones;
}
