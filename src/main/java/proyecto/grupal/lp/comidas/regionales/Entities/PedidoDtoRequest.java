package proyecto.grupal.lp.comidas.regionales.Entities;

import java.time.LocalDate;
import java.util.List;

public class PedidoDtoRequest {

    private LocalDate fecha;
    private String tipoPedido;
    private List<PedidoDto> listaPedido;

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

    public List<PedidoDto> getListaPedido() {
        return listaPedido;
    }

    public void setListaPedido(List<PedidoDto> listaPedido) {
        this.listaPedido = listaPedido;
    }

}
