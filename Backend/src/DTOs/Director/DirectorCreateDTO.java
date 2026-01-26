package DTOs.Director;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorCreateDTO {
    @NotBlank(message = "El nombre del director es obligatorio")
    private String nombre;
}
