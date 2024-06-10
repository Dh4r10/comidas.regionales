package proyecto.grupal.lp.comidas.regionales.Entities;
import jakarta.persistence.*;

import java.util.List;

import org.hibernate.annotations.SQLDelete;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "modulo")
@SQLDelete(sql = "UPDATE modulo SET estado = false WHERE id = ?")
public class Modulo {
	// CAMPOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    private Integer clave;
    private String nombre;
    private String icon;
    private Boolean estado;
    
    @OneToMany (mappedBy = "modulo", fetch = FetchType.LAZY)
    @JsonIgnore
    private List <Pantalla> pantalla;
    
   	//GETTERS Y SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public List<Pantalla> getPantalla() {
		return pantalla;
	}

	public void setPantalla(List<Pantalla> pantalla) {
		this.pantalla = pantalla;
	}

	@Override
	public String toString() {
		return "Modulo [id=" + id + ", clave=" + clave + ", nombre=" + nombre + ", icon=" + icon + ", estado=" + estado
					+ ", pantalla=" + pantalla + "]";
		}
	
	//CONSTRUCTORES
	public Modulo() {
		super();
		}		

}