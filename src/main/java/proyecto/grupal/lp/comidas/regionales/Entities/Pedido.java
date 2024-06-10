package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pedido")
@SQLDelete(sql = "UPDATE pedido SET estado = false WHERE id = ?")
public class Pedido {

    // CAMPOS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private String tipoPedido;
    private Boolean estado;

    @OneToOne (mappedBy = "pedido", fetch = FetchType.LAZY)
    @JsonIgnore
    private Delivery delivery;

    @OneToMany (mappedBy = "pedido", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DetallePedido> detallePedido;

    @OneToMany (mappedBy = "pedido", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DetalleMesa> detalleMesa;

    @OneToOne
    private Venta venta;

    // CONSTRUCTOR

    public Pedido() {}

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
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

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<DetalleMesa> getDetalleMesa() {
        return detalleMesa;
    }

    public void setDetalleMesa(List<DetalleMesa> detalleMesa) {
        this.detalleMesa = detalleMesa;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", tipoPedido='" + tipoPedido + '\'' +
                ", estado=" + estado +
                ", delivery=" + delivery +
                ", detallePedido=" + detallePedido +
                ", detalleMesa=" + detalleMesa +
                ", venta=" + venta +
                '}';
    }
}
