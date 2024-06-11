package proyecto.grupal.lp.comidas.regionales.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetallePedidoDto {

    @JsonProperty("id")
    private Long idDetallePedido;

    private Long idPedido;
    private Long idProducto;

    private String descripcion;
    private Integer cantidad;
    private Boolean estado;

    public Long getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Long idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
