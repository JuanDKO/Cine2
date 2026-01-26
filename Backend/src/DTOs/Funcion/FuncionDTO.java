package DTOs.Funcion;

import DTOs.Pelicula.PeliculaDTO;
import DTOs.Sala.SalaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionDTO {
    private long id;
    private LocalDate fechaHora;
    private double precio;
    private PeliculaDTO pelicula;

    @JsonIgnoreProperties("funciones")
    private SalaDTO sala;
}
