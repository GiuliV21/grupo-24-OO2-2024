package com.unla.grupo24.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "stock")
public  class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stock")
    protected long idStock;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    protected Producto producto;

    public Stock(long idStock, Producto producto) {
        this.idStock = idStock;
        this.producto = producto;
    }
    public Stock() {
   
    }

	public long getIdStock() {
		return idStock;
	}
	public void setIdStock(long idStock) {
		this.idStock = idStock;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
    
    
    
}
