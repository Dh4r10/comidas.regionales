package proyecto.grupal.lp.comidas.regionales.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name="parametros")
@SQLDelete(sql="UPDATE parametros SET estado=false WHERE id=?")
public class Parametros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean estado;

    @ManyToOne
    private Estaticas estaticas;

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

    public Estaticas getIdEstaticas() {
        return estaticas;
    }

    public void setIdEstaticas(Estaticas idEstaticas) {
        this.estaticas = idEstaticas;
    }

    @Override
    public String toString() {
        return "Parametros{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", idEstaticas=" + estaticas +
                '}';
    }
}
