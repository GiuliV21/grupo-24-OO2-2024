
package entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="RolUsuario", uniqueConstraints=@UniqueConstraint(columnNames= {"Rol", "Usuario"}))
public class RolUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;

	
	
	@OneToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;


	@Column(name="Rol", nullable=false, length=100)
	private String rol;


	public RolUsuario() {}

	public RolUsuario(int id, Usuario Usuario, String rol) {
		this.idRol = id;
		this.usuario = Usuario;
		this.rol = rol;
	}


	
}
