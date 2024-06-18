package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stock")
    protected long idStock;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    protected Producto producto;

    public Stock(long idStock, Producto producto){
        this.idStock = idStock;
        this.producto = producto;
    }
}
