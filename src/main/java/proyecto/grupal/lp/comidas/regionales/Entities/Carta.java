package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Entity
@Table(name = "carta")
@SQLDelete(sql = "UPDATE carta SET estado = false WHERE id = ?")
public class Carta {

    // CAMPOS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Boolean estado;

    @OneToMany (mappedBy = "carta", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Seccion> seccion;

    // CONSTRUCTOR

    public Carta() {
    }

    // GETTERS Y SETTERS

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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Seccion> getSeccion() {
        return seccion;
    }

    public void setSeccion(List<Seccion> seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estado=" + estado +
                ", seccion=" + seccion +
                '}';
    }
}
