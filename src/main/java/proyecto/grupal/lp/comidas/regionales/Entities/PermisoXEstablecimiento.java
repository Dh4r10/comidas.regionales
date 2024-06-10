package proyecto.grupal.lp.comidas.regionales.Entities;

import org.hibernate.annotations.SQLDelete;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "permisoXEstablecimiento")
@SQLDelete(sql = "UPDATE permisoXEstablecimiento SET estado = false WHERE id = ?")

public class PermisoXEstablecimiento {
	//CAMPOS
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn (name="permiso_id", referencedColumnName = "id", foreignKey =@ForeignKey(name = "FK_PXE_PE"), nullable=false)
    private Permiso permiso;
	
    private Boolean estado;
    
    //GETTERS Y SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Permiso getPermiso() {
		return permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "PermisoXEstablecimiento [id=" + id + ", permiso=" + permiso + ", estado=" + estado + "]";
	}

	public PermisoXEstablecimiento() {
		super();
	}
    
    
}
