package Clase;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ventas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
    private long id;
    private LocalDate fecha;
    @Column(name = "importe_total")
    private double importeTotal;
    @Column(name = "metodo_pago")
    private String metodoPago;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "usuarioId",nullable = false)
    private Usuario usuario;

    //Entradas compradas en la venta
    @OneToMany(mappedBy = "ventas")
    private List<Entrada> entradas;
}
