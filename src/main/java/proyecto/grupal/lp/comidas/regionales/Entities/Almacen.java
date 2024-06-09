package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Entity
@Table(name = "almacen")
@SQLDelete(sql = "UPDATE almacen SET estado = false WHERE id = ?")
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    @OneToMany(mappedBy = "almacen", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Pasillo> pasillo;

    //GETTERS AN SETTERS

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

    public List<Pasillo> getPasillo() {
        return pasillo;
    }

    public void setPasillo(List<Pasillo> pasillo) {
        this.pasillo = pasillo;
    }

    @Override
    public String toString() {
        return "Almacen{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", pasillo=" + pasillo +
                '}';
    }

    public Almacen() {
    }
}
