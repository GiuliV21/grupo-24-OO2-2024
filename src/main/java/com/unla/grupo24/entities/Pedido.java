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
@Table(name = "Pedido")
public class Pedido extends Stock {

    @Column(name = "cantidad_solicitada")
    private int cantidadSolicitada;

    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    public Pedido() {
        super();
    }

    public Pedido(long idStock, Producto producto, int cantidadSolicitada, LocalDate fechaPedido) {
        super(idStock, producto);
        this.cantidadSolicitada = cantidadSolicitada;
        this.fechaPedido = fechaPedido;
    }

    // Getters and setters
    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(int cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
    
    
}
