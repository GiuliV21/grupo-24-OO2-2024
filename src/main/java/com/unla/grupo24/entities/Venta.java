package com.unla.grupo24.entities;

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

	public long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Set<ItemVenta> getItemsVenta() {
		return itemsVenta;
	}

	public void setItemsVenta(Set<ItemVenta> itemsVenta) {
		this.itemsVenta = itemsVenta;
	}


}
