package DTOs.Entrada;

import DTOs.Funcion.FuncionDTO;
import DTOs.Venta.VentaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaDTO {
    private long id;
    private String codigo;
    private int fila;
    private int asiento;
    private String estadoEntrada;
    private VentaDTO venta;
    private FuncionDTO funcion;
}
