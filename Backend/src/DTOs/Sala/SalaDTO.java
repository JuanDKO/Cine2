package DTOs.Sala;

import DTOs.Funcion.FuncionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaDTO {
    private long id;
    private String nombre;
    private int capacidad;
    private List<FuncionDTO> funciones;
}
