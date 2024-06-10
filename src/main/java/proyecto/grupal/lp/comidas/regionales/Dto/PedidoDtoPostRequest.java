package proyecto.grupal.lp.comidas.regionales.Dto;

import java.time.LocalDate;
import java.util.List;

public class PedidoDtoPostRequest {

    private LocalDate fecha;
    private String tipoPedido;
    private String direccion;
    private String numeroContacto;
    private List<DetallePedidoDto> listaPedido;
    private List<DetalleMesaDto> listaMesa;

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public List<DetallePedidoDto> getListaPedido() {
        return listaPedido;
    }

    public void setListaPedido(List<DetallePedidoDto> listaPedido) {
        this.listaPedido = listaPedido;
    }

    public List<DetalleMesaDto> getListaMesa() {
        return listaMesa;
    }

    public void setListaMesa(List<DetalleMesaDto> listaMesa) {
        this.listaMesa = listaMesa;
    }
}
