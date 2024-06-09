package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Entity
@Table(name = "movimientoInsumo")
@SQLDelete(sql = "UPDATE movimientoInsumo SET estado = false WHERE id = ?")
public class MovimientoInsumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn (name = "detalle_compra_id", referencedColumnName = "id", foreignKey = @ForeignKey (name = "FK_MI_DC"), nullable = false)
    private DetalleCompra detalleCompra;
    private String tipoMovimmiento;
    private Integer cantidad;
    private LocalDate fecha;
    private LocalTime hora;
    private String descripcion;
    private Boolean estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DetalleCompra getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(DetalleCompra detalleCompra) {
        this.detalleCompra = detalleCompra;
    }

    public String getTipoMovimmiento() {
        return tipoMovimmiento;
    }

    public void setTipoMovimmiento(String tipoMovimmiento) {
        this.tipoMovimmiento = tipoMovimmiento;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
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

    @Override
    public String toString() {
        return "MovimientoInsumo{" +
                "id=" + id +
                ", detalleCompra=" + detalleCompra +
                ", tipoMovimmiento='" + tipoMovimmiento + '\'' +
                ", cantidad=" + cantidad +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                '}';
    }

    public MovimientoInsumo() {
    }
}
