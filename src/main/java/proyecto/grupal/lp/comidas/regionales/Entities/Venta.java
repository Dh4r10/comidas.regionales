package proyecto.grupal.lp.comidas.regionales.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ventas")
@SQLDelete(sql = "UPDATE ventas SET estado = false WHERE id=?")
@SQLRestriction("estado = true")
public class Venta {

    @Id
    private Long id;

    private String codigoRecibo;
    private String descripcion;
    private String tipoComprobante;

    private String metodoPago;
    private String tipoPago;

    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private Boolean cancelado;
    private Boolean estado;


    @ManyToOne
    @JoinColumn(name = "cliente_id",referencedColumnName = "id")
    private Cliente cliente;

    @OneToMany(mappedBy = "venta",fetch =FetchType.LAZY )
    private List<DetalleVenta> detalleVentas=new ArrayList<>();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleVenta> getDetalleVentas() {
        return detalleVentas;
    }

    public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
        this.detalleVentas = detalleVentas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoRecibo() {
        return codigoRecibo;
    }

    public void setCodigoRecibo(String codigoRecibo) {
        this.codigoRecibo = codigoRecibo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
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

    public Boolean getCancelado() {
        return cancelado;
    }

    public void setCancelado(Boolean cancelado) {
        this.cancelado = cancelado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
