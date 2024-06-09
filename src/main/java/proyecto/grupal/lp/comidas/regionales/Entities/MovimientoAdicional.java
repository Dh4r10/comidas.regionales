package proyecto.grupal.lp.comidas.regionales.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="movimiento_adicional")
public class MovimientoAdicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;
    private Double monto;
    private Double total;
    private LocalDate fecha;
    private String descripcion;
    private Boolean estado;

    @ManyToOne
    private Apertura apertura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

    public Apertura getApertura() {
        return apertura;
    }

    public void setApertura(Apertura apertura) {
        this.apertura = apertura;
    }

    @Override
    public String toString() {
        return "Movimientos{" +
                "id=" + id +
                ", tipoMovimiento='" + tipoMovimiento + '\'' +
                ", monto=" + monto +
                ", total=" + total +
                ", fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", apertura=" + apertura +
                '}';
    }
}
