package proyecto.grupal.lp.comidas.regionales.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "detalle_mesa")
@SQLDelete(sql = "UPDATE detalle_mesa SET estado = false WHERE id = ?")
public class DetalleMesa {

    // CAMPOS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
	@JoinColumn(name="pedido_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_DEPEME_DEPE"), nullable = false)
    private Pedido pedido;

    @ManyToOne
	@JoinColumn (name="mesa_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_DEPEME_ME"), nullable = false)
    private Mesa mesa;

    private Boolean estado;

    // CONSTRUCTOR

    public DetalleMesa() {}

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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
                ", pedido=" + pedido +
                ", mesa=" + mesa +
                ", estado=" + estado +
                '}';
    }
}
