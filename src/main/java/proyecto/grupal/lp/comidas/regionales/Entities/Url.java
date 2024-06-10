package proyecto.grupal.lp.comidas.regionales.Entities;

import org.hibernate.annotations.SQLDelete;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "url")
@SQLDelete(sql = "UPDATE url SET estado = false WHERE id = ?")

public class Url {
	 // CAMPOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String path;
    private String unionPath;
    private String alias;
    private Boolean estado;
    
    @OneToOne (mappedBy = "url", fetch = FetchType.LAZY)
    @JsonIgnore
    private Pantalla pantalla;
    
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUnionPath() {
		return unionPath;
	}

	public void setUnionPath(String unionPath) {
		this.unionPath = unionPath;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Pantalla getPantalla() {
		return pantalla;
	}

	public void setPantalla(Pantalla pantalla) {
		this.pantalla = pantalla;
	}
    

	@Override
	public String toString() {
		return "Url [id=" + id + ", nombre=" + nombre + ", path=" + path + ", unionPath=" + unionPath + ", alias="
				+ alias + ", estado=" + estado + ", pantalla=" + pantalla + "]";
	}

	public Url() {
		super();
	}
}
