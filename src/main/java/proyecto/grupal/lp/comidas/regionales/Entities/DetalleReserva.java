package proyecto.grupal.lp.comidas.regionales.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "detalle_reserva")
@SQLDelete(sql = "UPDATE detalle_reserva SET estado = false WHERE id = ?")
public class DetalleReserva {

    // CAMPOS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
	@JoinColumn (name="reserva_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_DERE_RE"), nullable = false)
    private Reserva reserva;

    @ManyToOne
	@JoinColumn (name="mesa_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_DERE_ME"), nullable = false)
    private Mesa mesa;

    private Boolean estado;

    // CONSTRUCTOR

    public DetalleReserva() {}

    // GETTERS Y SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
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
        return "DetalleReserva{" +
                "id=" + id +
                ", reserva=" + reserva +
                ", mesa=" + mesa +
                ", estado=" + estado +
                '}';
    }
}
