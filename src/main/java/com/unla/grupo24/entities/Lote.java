package com.unla.grupo24.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Lote")
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lote")
    private long idLote;

    @Column(name = "cantidad_recibida")
    private int cantidadRecibida;

    @Column(name = "fecha_recepcion")
    private LocalDate fechaRecepcion;

    @Column(name = "precio_compra")
    private double precioCompra;

    @ManyToOne
    @JoinColumn(name = "almacen_id")
    private Almacen almacen;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    public Lote() {}
    
    public Lote(long idLote, int cantidadRecibida, LocalDate fechaRecepcion, double precioCompra) {
        this.idLote = idLote;
        this.cantidadRecibida = cantidadRecibida;
        this.fechaRecepcion = fechaRecepcion;
        this.precioCompra = precioCompra;
    }
}
