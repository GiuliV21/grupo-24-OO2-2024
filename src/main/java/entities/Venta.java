package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private long idVenta;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario cliente;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "total")
    private double total;

    @OneToMany(mappedBy = "venta")
    private Set<ItemVenta> itemsVenta;

    public Venta(long idVenta, Usuario cliente, LocalDate fecha, double total) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.fecha = fecha;
        this.total = total;
    }
}
