package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "detalle_pedido")
@SQLDelete(sql = "UPDATE detalle_pedido SET estado = false WHERE id = ?")
public class DetallePedido {

    // CAMPOS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
	@JoinColumn (name="producto_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_DEPE_PR"), nullable = false)
    private Producto producto;

    @ManyToOne
	@JoinColumn (name="pedido_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_DEPE_PE"), nullable = false)
    private Pedido pedido;

    private String descripcion;
    private Integer cantidad;
    private Boolean estado;

    // CONSTRUCTOR

    public DetallePedido() {}

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "id=" + id +
                ", producto=" + producto +
                ", pedido=" + pedido +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", estado=" + estado +
                '}';
    }
}