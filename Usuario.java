package entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="nombreUsuario", unique=true, nullable=false, length=45)
	private String nombreUsuario;

	@Column(name="contrasenia", nullable=false, length=60)
	private String contrasenia;

	@OneToOne
	@JoinColumn(name="rolUsuario")
	private RolUsuario rol;

	public Usuario() {}
	
	public Usuario(String nombreUsuario, String contrasenia, boolean enabled) {
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
			}

	public Usuario(String nombreUsuario, String contrasenia, RolUsuario rol) {
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.rol = rol;
	}

	
	
}