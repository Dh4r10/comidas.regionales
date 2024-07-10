package proyecto.grupal.lp.comidas.regionales.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalleMesaGetDto {
    private Long pedidoId;

    private LocalDate fechaPedido;
    private boolean pendiente;

    public boolean getPendiente() {
        return pendiente;
    }

    public void setPendiente(boolean pendiente) {
        this.pendiente = pendiente;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }
}
