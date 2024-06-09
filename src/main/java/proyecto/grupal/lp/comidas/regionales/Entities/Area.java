package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Entity
@Table(name = "area")
@SQLDelete(sql = "UPDATE area SET estado = false WHERE id = ?")
public class Area {

    // CAMPOS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
	@JoinColumn (name="salon_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_AR_SA"), nullable = false)
    private Salon salon;

    private String nombre;
    private String descripcion;
    private Boolean estado;

    @OneToMany (mappedBy = "area", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Mesa> mesa;

    // CONSTRUCTOR

    public Area() {
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
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

    public List<Mesa> getMesa() {
        return mesa;
    }

    public void setMesa(List<Mesa> mesa) {
        this.mesa = mesa;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", salon=" + salon +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", mesa=" + mesa +
                '}';
    }
}
