package proyecto.grupal.lp.comidas.regionales.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class DetallePedidoSalonGetRequest {
    @JsonProperty("id")
    private Long pedidoId;

    private LocalDate fecha;
    private String tipoPedido;

    private String estadoPedido;

    private List<DetallePedidoProductoDto> productos;
    private List<DetalleMesaMesaDto> mesas;

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public List<DetallePedidoProductoDto> getProductos() {
        return productos;
    }

    public void setProductos(List<DetallePedidoProductoDto> productos) {
        this.productos = productos;
    }

    public List<DetalleMesaMesaDto> getMesas() {
        return mesas;
    }

    public void setMesas(List<DetalleMesaMesaDto> mesas) {
        this.mesas = mesas;
    }
}