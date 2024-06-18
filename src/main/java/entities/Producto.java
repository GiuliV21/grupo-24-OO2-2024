package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private long idProducto;

    private String codigo;
    private String descripcion;
    private double costo;
    private double precioVenta;

    public Producto(long idProducto, String codigo, String descripcion, double costo, double precioVenta){
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.precioVenta = precioVenta;
    }
}
