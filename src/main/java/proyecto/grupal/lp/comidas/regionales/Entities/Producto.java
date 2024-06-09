package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "producto")
@SQLDelete(sql = "UPDATE producto SET estado = false WHERE id = ?")
public class Producto {

    // CAMPOS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
	@JoinColumn (name="categoria_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_PR_CA"), nullable = false)
    private Categoria categoria;

    private String tipoProducto;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String imagen;
    private Boolean estado;

    @OneToMany (mappedBy = "producto", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DetallePedido> detallePedido;

    // CONSTRUCTOR

    public Producto() {
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<DetallePedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(List<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", categoria=" + categoria +
                ", tipoProducto='" + tipoProducto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", imagen='" + imagen + '\'' +
                ", estado=" + estado +
                ", detallePedido=" + detallePedido +
                '}';
    }
}
