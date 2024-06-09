package proyecto.grupal.lp.comidas.regionales.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "detalle_pedido_mesa")
@SQLDelete(sql = "UPDATE detalle_pedido_mesa SET estado = false WHERE id = ?")
public class DetallePedidoMesa {

    // CAMPOS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
	@JoinColumn(name="detalle_pedido_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_DEPEME_DEPE"), nullable = false)
    private DetallePedido detallePedido;

    @ManyToOne
	@JoinColumn (name="mesa_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_DEPEME_ME"), nullable = false)
    private Mesa mesa;

    private Boolean estado;

    // CONSTRUCTOR

    public DetallePedidoMesa() {}

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DetallePedido getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(DetallePedido detallePedido) {
        this.detallePedido = detallePedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "DetallePedidoMesa{" +
                "id=" + id +
                ", detallePedido=" + detallePedido +
                ", mesa=" + mesa +
                ", estado=" + estado +
                '}';
    }
}
