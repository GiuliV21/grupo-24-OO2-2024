package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto") 
    private long idProducto;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "costo")
    private double costo;
    @Column(name = "precioVenta")
    private double precioVenta;

    public Producto(long idProducto, String codigo, String descripcion, double costo, double precioVenta){
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.precioVenta = precioVenta;
    }
}
