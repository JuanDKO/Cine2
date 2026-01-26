package Clase;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "entradas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codigo;
    private int fila;
    private int asiento;
    @Column(name = "estado_entrada")
    private String estadoEntrada;

    @ManyToOne
    @JoinColumn(name = "ventaId",nullable = false)
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "funcionId", nullable = false)
    private Funcion funcion;
}
