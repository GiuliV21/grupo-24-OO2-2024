package com.unla.grupo24.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    protected long idProveedor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "num_contacto")
    private String numContacto;

    public Proveedor(long idProveedor, String nombre, String numContacto) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.numContacto = numContacto;
    }
    public Proveedor() {
    }
	public long getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(long idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumContacto() {
		return numContacto;
	}
	public void setNumContacto(String numContacto) {
		this.numContacto = numContacto;
	}
    
    
    
}
