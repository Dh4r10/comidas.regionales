package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Entity
@Table(name = "mesa")
@SQLDelete(sql = "UPDATE mesa SET estado = false WHERE id = ?")
public class Mesa {

    // CAMPOS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
	@JoinColumn (name="area_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_ME_AR"), nullable = false)
    private Area area;

    private String tipoMesa;
    private Integer numero;
    private Integer capacidad;
    private Boolean reservado;
    private Boolean ocupado;
    private Boolean estado;

    @OneToMany (mappedBy = "mesa", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DetalleReserva> detalleReserva;

    @OneToMany (mappedBy = "mesa", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DetallePedidoMesa> detallePedidoMesa;

    // CONSTRUCTOR

    public Mesa() {
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getTipoMesa() {
        return tipoMesa;
    }

    public void setTipoMesa(String tipoMesa) {
        this.tipoMesa = tipoMesa;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Boolean getReservado() {
        return reservado;
    }

    public void setReservado(Boolean reservado) {
        this.reservado = reservado;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<DetalleReserva> getDetalleReserva() {
        return detalleReserva;
    }

    public void setDetalleReserva(List<DetalleReserva> detalleReserva) {
        this.detalleReserva = detalleReserva;
    }

    public List<DetallePedidoMesa> getDetallePedidoMesa() {
        return detallePedidoMesa;
    }

    public void setDetallePedidoMesa(List<DetallePedidoMesa> detallePedidoMesa) {
        this.detallePedidoMesa = detallePedidoMesa;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "id=" + id +
                ", area=" + area +
                ", tipoMesa='" + tipoMesa + '\'' +
                ", numero=" + numero +
                ", capacidad=" + capacidad +
                ", reservado=" + reservado +
                ", ocupado=" + ocupado +
                ", estado=" + estado +
                ", detalleReserva=" + detalleReserva +
                ", detallePedidoMesa=" + detallePedidoMesa +
                '}';
    }
}
