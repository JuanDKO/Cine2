package com.dam2.Practica1.loader;

import com.dam2.Practica1.model.Actor;
import com.dam2.Practica1.model.Director;
import com.dam2.Practica1.model.Pelicula;
import com.dam2.Practica1.repository.ActorRepository;
import com.dam2.Practica1.repository.DirectorRepository;
import com.dam2.Practica1.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public void run(String... args) throws Exception {
        // Simple check to prevent duplicate data insertion on restart
        if (peliculaRepository.count() > 0) {
            return;
        }

        System.out.println("Cargando datos iniciales...");

        // 1. Insert 10 Directors
        List<Director> directors = new ArrayList<>();
        String[] directorNames = {
                "Steven Spielberg",
                "Quentin Tarantino",
                "Martin Scorsese",
                "Christopher Nolan",
                "David Fincher",
                "Steven Soderbergh",
                "Francis Ford Coppola",
                "George Lucas",
                "Ridley Scott",
                "James Mangold"
        };

        for (String name : directorNames) {
            Director d = new Director();
            d.setNombre(name);
            directors.add(directorRepository.save(d));
        }

        // 2. Insert 20 Actors
        List<Actor> actors = new ArrayList<>();
        String[] actorNames = {
                "Leonardo DiCaprio",
                "Brad Pitt",
                "Tom Hanks",
                "Matt Damon",
                "Robert De Niro",
                "Al Pacino",
                "Samuel L. Jackson",
                "Morgan Freeman",
                "Christian Bale",
                "Tom Hardy",
                "Margot Robbie",
                "Uma Thurman",
                "Harrison Ford",
                "Mark Hamill",
                "Edward Norton",
                "Jack Nicholson",
                "Matthew McConaughey",
                "Kate Winslet",
                "Russell Crowe",
                "Joaquin Phoenix"
        };

        for (String name : actorNames) {
            Actor a = new Actor();
            a.setNombre(name);
            a.setPeliculas(new ArrayList<>());
            actors.add(actorRepository.save(a));
        }

        // Helper to lookup actors by name
        Map<String, Actor> actorMap = new HashMap<>();
        for (Actor a : actors) {
            actorMap.put(a.getNombre(), a);
        }

        // 3. Insert 20 Movies with relationships
        // Directors index:
        // 0:Spielberg, 1:Tarantino, 2:Scorsese, 3:Nolan, 4:Fincher
        // 5:Soderbergh, 6:Coppola, 7:Lucas, 8:Scott, 9:Mangold

        createMovie("Catch Me If You Can", 141, 12, directors.get(0), Arrays.asList("Leonardo DiCaprio", "Tom Hanks"),
                actorMap);
        createMovie("Saving Private Ryan", 169, 16, directors.get(0), Arrays.asList("Tom Hanks", "Matt Damon"),
                actorMap);

        createMovie("Pulp Fiction", 154, 18, directors.get(1), Arrays.asList("Samuel L. Jackson", "Uma Thurman"),
                actorMap);
        createMovie("Once Upon a Time in Hollywood", 161, 16, directors.get(1),
                Arrays.asList("Leonardo DiCaprio", "Brad Pitt", "Margot Robbie"), actorMap);
        createMovie("Django Unchained", 165, 18, directors.get(1),
                Arrays.asList("Leonardo DiCaprio", "Samuel L. Jackson"), actorMap);

        createMovie("The Wolf of Wall Street", 180, 18, directors.get(2),
                Arrays.asList("Leonardo DiCaprio", "Margot Robbie", "Matthew McConaughey"), actorMap);
        createMovie("The Departed", 151, 18, directors.get(2),
                Arrays.asList("Leonardo DiCaprio", "Matt Damon", "Jack Nicholson"), actorMap);
        createMovie("The Irishman", 209, 16, directors.get(2), Arrays.asList("Robert De Niro", "Al Pacino"), actorMap);

        createMovie("Inception", 148, 12, directors.get(3), Arrays.asList("Leonardo DiCaprio", "Tom Hardy"), actorMap);
        createMovie("The Dark Knight Rises", 164, 12, directors.get(3),
                Arrays.asList("Christian Bale", "Tom Hardy", "Morgan Freeman"), actorMap);
        createMovie("Interstellar", 169, 12, directors.get(3), Arrays.asList("Matthew McConaughey", "Matt Damon"),
                actorMap);

        createMovie("Se7en", 127, 18, directors.get(4), Arrays.asList("Brad Pitt", "Morgan Freeman"), actorMap);
        createMovie("Fight Club", 139, 18, directors.get(4), Arrays.asList("Brad Pitt", "Edward Norton"), actorMap);

        createMovie("Ocean's Eleven", 116, 12, directors.get(5), Arrays.asList("Brad Pitt", "Matt Damon"), actorMap);
        createMovie("Contagion", 106, 12, directors.get(5), Arrays.asList("Matt Damon", "Kate Winslet"), actorMap);

        createMovie("The Godfather Part II", 202, 18, directors.get(6), Arrays.asList("Al Pacino", "Robert De Niro"),
                actorMap);

        createMovie("Star Wars: A New Hope", 121, 0, directors.get(7), Arrays.asList("Harrison Ford", "Mark Hamill"),
                actorMap);

        createMovie("Body of Lies", 128, 16, directors.get(8), Arrays.asList("Leonardo DiCaprio", "Russell Crowe"),
                actorMap);
        createMovie("Gladiator", 155, 16, directors.get(8), Arrays.asList("Russell Crowe", "Joaquin Phoenix"),
                actorMap);

        createMovie("Ford v Ferrari", 152, 12, directors.get(9), Arrays.asList("Matt Damon", "Christian Bale"),
                actorMap);

        System.out.println("Datos cargados correctamente.");
    }

    private void createMovie(String title, int duration, int minAge, Director director, List<String> actorNames,
            Map<String, Actor> actorMap) {
        Pelicula p = new Pelicula();
        p.setNombre(title);
        p.setDuracion(duration);
        p.setEdadMinima(minAge);
        p.setDirector(director);

        // Guardamos la película primero para generar su ID
        p = peliculaRepository.save(p);

        // Establecemos las relaciones con los actores
        // Como la relación es ManyToMany y el dueño es Actor (mapped by peliculas en
        // Actor es falso, es JoinTable en Actor),
        // debemos añadir la película a la lista de películas del actor y guardar el
        // actor.
        for (String name : actorNames) {
            // Con actorMap aceleramos la búsqueda del actor al cargarlos antes y
            // simplemente buscamos el nombre
            Actor a = actorMap.get(name);
            // Comprobamos que el actor existe
            if (a != null) {
                // Asegurarse de que la lista no sea null (la inicializamos antes, pero por
                // seguridad)
                // Comprueba si el actor tiene películas, si no, crea una lista
                if (a.getPeliculas() == null) {
                    a.setPeliculas(new ArrayList<>());
                }
                a.getPeliculas().add(p);
                actorRepository.save(a);
            }
        }
    }
}
