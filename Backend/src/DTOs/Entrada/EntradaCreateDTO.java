package DTOs.Entrada;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaCreateDTO {
    private String codigo;
    @NotNull(message = "La fila es obligatoria")
    private int fila;
    @NotNull(message = "El asiento es obligatorio")
    private int asiento;
    private String estadoEntrada;
    @NotNull(message = "El ID de la venta es obligatorio")
    private long ventaId;
    @NotNull(message = "El ID de la función es obligatorio")
    private long funcionId;
}
