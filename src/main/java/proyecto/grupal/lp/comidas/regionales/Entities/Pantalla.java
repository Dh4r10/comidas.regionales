package proyecto.grupal.lp.comidas.regionales.Entities;
import jakarta.persistence.*;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pantalla")
@SQLDelete(sql = "UPDATE pantalla SET estado = false WHERE id = ?")

public class Pantalla {
	 // CAMPOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "pantalla",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Permiso> permiso;
      
    @ManyToOne
	@JoinColumn (name="modulo_id", referencedColumnName = "id", foreignKey =@ForeignKey(name = "FK_M_P"), nullable=false)
    private Modulo modulo;
    
    @OneToOne
    @JoinColumn (name="url_id", referencedColumnName = "id", foreignKey =@ForeignKey(name = "FK_U_P"), nullable=false)
    private Url url;

    private Integer clave;
    private String nombre;
    private Boolean estado;
    
  //GETTERS Y SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Permiso> getPermiso() {
		return permiso;
	}

	public void setPermiso(List<Permiso> permiso) {
		this.permiso = permiso;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Url getUrl() {
		return url;
	}

	public void setUrl(Url url) {
		this.url = url;
	}

	public Integer getClave() {
		return clave;
	}

	public void setClave(Integer clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Pantalla [id=" + id + ", permiso=" + permiso + ", modulo=" + modulo + ", url=" + url + ", clave="
				+ clave + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
	

	//CONSTRUCTOR
	public Pantalla() {
		super();
		}
}
