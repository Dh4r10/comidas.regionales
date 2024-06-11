package proyecto.grupal.lp.comidas.regionales.Dto;

import java.time.LocalDate;
import java.util.List;

public class DeliveryGetRequestDto {

    private long idPedido;
    private String tipoPedido;
    private String numContacto;
    private String direccion;
    private LocalDate fecha;
    private String estadoPedido;
    private List<DetallePedidoDtoCopia> listaPedidos;

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getNumContacto() {
        return numContacto;
    }

    public void setNumContacto(String numContacto) {
        this.numContacto = numContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public List<DetallePedidoDtoCopia> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<DetallePedidoDtoCopia> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
}
