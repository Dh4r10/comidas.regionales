package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "detalleCompra")
@SQLDelete(sql = "UPDATE detalleCompra SET estado = false WHERE id = ?")
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn (name = "insumo_id", referencedColumnName = "id", foreignKey = @ForeignKey (name = "FK_DC_IN"), nullable = false)
    private Insumo insumo;
    @ManyToOne
    @JoinColumn (name = "compra_id", referencedColumnName = "id", foreignKey = @ForeignKey (name = "FK_CO_CO"), nullable = false)
    private Compra compra;
    private String codigoLote;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private LocalDate fechaRecepcion;
    private LocalDate fechaVencimiento;
    private Boolean estado;
    @OneToMany(mappedBy = "detalleCompra", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MovimientoInsumo> movimientoInsumo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public String getCodigoLote() {
        return codigoLote;
    }

    public void setCodigoLote(String codigoLote) {
        this.codigoLote = codigoLote;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public LocalDate getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDate fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<MovimientoInsumo> getMovimientoInsumo() {
        return movimientoInsumo;
    }

    public void setMovimientoInsumo(List<MovimientoInsumo> movimientoInsumo) {
        this.movimientoInsumo = movimientoInsumo;
    }

    @Override
    public String toString() {
        return "DetalleCompra{" +
                "id=" + id +
                ", insumo=" + insumo +
                ", compra=" + compra +
                ", codigoLote='" + codigoLote + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", fechaRecepcion=" + fechaRecepcion +
                ", fechaVencimiento=" + fechaVencimiento +
                ", estado=" + estado +
                ", movimientoInsumo=" + movimientoInsumo +
                '}';
    }

    public DetalleCompra() {
    }
}
