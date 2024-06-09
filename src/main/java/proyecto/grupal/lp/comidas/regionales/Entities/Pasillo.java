package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Entity
@Table(name = "pasillo")
@SQLDelete(sql = "UPDATE pasillo SET estado = false WHERE id = ?")
public class Pasillo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn (name = "Amacen_id", referencedColumnName = "id", foreignKey = @ForeignKey (name = "FK_PA_ALM"), nullable = false)
    private Almacen almacen;
    private String numero;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    @OneToMany(mappedBy = "pasillo", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Ubicacion> ubicacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public List<Ubicacion> getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(List<Ubicacion> ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Pasillo{" +
                "id=" + id +
                ", almacen=" + almacen +
                ", numero='" + numero + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", ubicacion=" + ubicacion +
                '}';
    }

    public Pasillo() {
    }
}
