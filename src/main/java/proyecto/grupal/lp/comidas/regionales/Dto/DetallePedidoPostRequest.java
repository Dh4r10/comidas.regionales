package proyecto.grupal.lp.comidas.regionales.Dto;

import java.time.LocalDate;
import java.util.List;

public class DetallePedidoPostRequest {

    private LocalDate fecha;
    private String tipoPedido;

    private String direccion;
    private String numeroContacto;

    private List<DetallePedidoDto> listaPedidos;
    private List<DetalleMesaDto> listaMesas;

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

    public List<DetallePedidoDto> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<DetallePedidoDto> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public List<DetalleMesaDto> getListaMesas() {
        return listaMesas;
    }

    public void setListaMesas(List<DetalleMesaDto> listaMesas) {
        this.listaMesas = listaMesas;
    }
}
