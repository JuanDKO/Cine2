package DTOs.Pelicula;

import DTOs.Director.DirectorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaDTO {
    private long id;
    private String nombre;
    private int duracion;
    private int edadMinima;
    private DirectorDTO director;
}
