package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private long idPedido;

    @Column(name = "cantidad_solicitada")
    private int cantidadSolicitada;

    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    public Pedido(long idPedido, int cantidadSolicitada, LocalDate fechaPedido) {
        this.idPedido = idPedido;
        this.cantidadSolicitada = cantidadSolicitada;
        this.fechaPedido = fechaPedido;
    }
}
