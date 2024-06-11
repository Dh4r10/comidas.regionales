package proyecto.grupal.lp.comidas.regionales.Entities;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "tipo_usuario", uniqueConstraints = {
		@UniqueConstraint(columnNames = "nombre", name = "NOMBRE_UQ")
})
@SQLDelete(sql = "UPDATE tipo_usuario SET estado = false WHERE id = ?")
public class TipoUsuario {
	// CAMPOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private Boolean estado;
    
    @OneToMany (mappedBy = "tipoUsuario", fetch = FetchType.LAZY)
    @JsonIgnore
    private List <Usuario> usuario;
    
    //GETTERS Y SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "TipoUsuario [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", usuario=" + usuario + "]";
	}

	public TipoUsuario() {
		super();
	}
    
}