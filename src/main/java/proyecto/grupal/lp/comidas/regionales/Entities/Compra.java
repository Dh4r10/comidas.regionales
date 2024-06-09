package proyecto.grupal.lp.comidas.regionales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "compra")
@SQLDelete(sql = "UPDATE compra SET estado = false WHERE id = ?")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn (name = "proveedor_id", referencedColumnName = "id", foreignKey = @ForeignKey (name = "FK_CO_PRO"), nullable = false)
    private Proveedor proveedor;
    private String codigoRecibo;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private String descripcion;
    private Boolean estado;
    @OneToMany(mappedBy = "compra", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DetalleCompra> detalleCompra;

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getCodigoRecibo() {
        return codigoRecibo;
    }

    public void setCodigoRecibo(String codigoRecibo) {
        this.codigoRecibo = codigoRecibo;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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

    public List<DetalleCompra> getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(List<DetalleCompra> detalleCompra) {
        this.detalleCompra = detalleCompra;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", proveedor=" + proveedor +
                ", codigoRecibo='" + codigoRecibo + '\'' +
                ", fechaEmision=" + fechaEmision +
                ", fechaVencimiento=" + fechaVencimiento +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", detalleCompra=" + detalleCompra +
                '}';
    }

    public Compra() {
    }
}

