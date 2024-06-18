package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stock")
    private long idStock;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public Stock(long idStock, Producto producto) {
        this.idStock = idStock;
        this.producto = producto;
    }
}
