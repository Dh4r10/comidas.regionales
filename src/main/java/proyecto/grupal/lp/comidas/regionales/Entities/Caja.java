package proyecto.grupal.lp.comidas.regionales.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name="caja")
@SQLDelete(sql="UPDATE caja SET estado=false WHERE id=?")
public class Caja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false,length=100)
    private String nombre;
    @Column(nullable=false,length=150)
    private String descripcion;
    private Boolean estado;
    @ManyToOne
    private Sucursal Sucursal;

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

    public Sucursal getIdSucursal() {
        return Sucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.Sucursal = idSucursal;
    }

    @Override
    public String toString() {
        return "Caja{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", idSucursal=" + Sucursal +
                '}';
    }
}
