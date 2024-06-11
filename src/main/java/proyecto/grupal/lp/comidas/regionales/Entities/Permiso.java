package proyecto.grupal.lp.comidas.regionales.Entities;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "permiso")
@SQLDelete(sql = "UPDATE permiso SET estado = false WHERE id = ?")

public class Permiso {
	//CAMPOS
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	@JoinColumn (name="pantalla_id", referencedColumnName = "id", foreignKey =@ForeignKey(name = "FK_P_PE"), nullable=false)
    private Pantalla pantalla;
	
	@ManyToOne
	@JoinColumn (name="tipo_usuario_id", referencedColumnName = "id", foreignKey =@ForeignKey(name = "FK_TU_PE"), nullable=false)
    private TipoUsuario tipoUsuario;
	
	@OneToMany (mappedBy = "permiso", fetch = FetchType.LAZY)
    @JsonIgnore
	private List <PermisoXEstablecimiento> permisoXEstablecimiento;
	
    private Boolean estado;

	//SETTERS Y GETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pantalla getPantalla() {
		return pantalla;
	}

	public void setPantalla(Pantalla pantalla) {
		this.pantalla = pantalla;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<PermisoXEstablecimiento> getPermisoXEstablecimiento() {
		return permisoXEstablecimiento;
	}

	public void setPermisoXEstablecimiento(List<PermisoXEstablecimiento> permisoXEstablecimiento) {
		this.permisoXEstablecimiento = permisoXEstablecimiento;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Permiso [id=" + id + ", pantalla=" + pantalla + ", tipoUsuario=" + tipoUsuario
				+ ", permisoXEstablecimiento=" + permisoXEstablecimiento + ", estado=" + estado + "]";
	}

	public Permiso() {
		super();
	}
	
}
	