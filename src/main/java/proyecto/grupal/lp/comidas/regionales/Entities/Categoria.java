package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Entity
@Table(name = "categoria")
@SQLDelete(sql = "UPDATE categoria SET estado = false WHERE id = ?")
public class Categoria {

    // CAMPOS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
	@JoinColumn (name="seccion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_CA_SE"), nullable = false)
    private Seccion seccion;

    private String nombre;
    private Boolean estado;

    @OneToMany (mappedBy = "categoria", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Producto> producto;

    // CONSTRUCTOR

    public Categoria() {
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
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

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", seccion=" + seccion +
                ", nombre='" + nombre + '\'' +
                ", estado=" + estado +
                ", producto=" + producto +
                '}';
    }
}
