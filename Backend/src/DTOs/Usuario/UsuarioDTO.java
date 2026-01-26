package DTOs.Usuario;

import DTOs.Venta.VentaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private long id;
    private String email;
    private boolean enabled;

    @JsonIgnoreProperties("usuario")
    private List<VentaDTO> ventas;
}
