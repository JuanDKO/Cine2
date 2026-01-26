package DTOs.Actor;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDTO {
    private long id;

    @NotBlank(message = "El actor siempe debe tener nombre")
    private String nombre;

}
