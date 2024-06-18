package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Almacen")
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_almacen")
    private long idAlmacen;
    
    @Column(name = "cantidad_actual")
    private int cantidadActual;
    
    @Column(name = "cantidad_critica")
    private int cantidadCritica;
    
    @Column(name = "ubicacion")
    private String ubicacion;

    @OneToMany(mappedBy = "almacen")
    private Set<Lote> lotes;

    public Almacen(long idAlmacen, int cantidadActual, int cantidadCritica, String ubicacion) {
        this.idAlmacen = idAlmacen;
        this.cantidadActual = cantidadActual;
        this.cantidadCritica = cantidadCritica;
        this.ubicacion = ubicacion;
    }
}
