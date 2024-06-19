package com.unla.grupo24.entities;

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
    public Almacen() {}
    public Almacen(long idAlmacen, int cantidadActual, int cantidadCritica, String ubicacion) {
        this.idAlmacen = idAlmacen;
        this.cantidadActual = cantidadActual;
        this.cantidadCritica = cantidadCritica;
        this.ubicacion = ubicacion;
    }

	public long getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(long idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}

	public int getCantidadCritica() {
		return cantidadCritica;
	}

	public void setCantidadCritica(int cantidadCritica) {
		this.cantidadCritica = cantidadCritica;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Set<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(Set<Lote> lotes) {
		this.lotes = lotes;
	}


}
