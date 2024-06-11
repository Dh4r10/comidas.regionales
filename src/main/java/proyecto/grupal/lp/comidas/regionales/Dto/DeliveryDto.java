package proyecto.grupal.lp.comidas.regionales.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import proyecto.grupal.lp.comidas.regionales.Entities.Pedido;

public class DeliveryDto {

    @JsonProperty("id")
    private Long idDelivery;

    private Pedido pedido;

    private String direccion;
    private String numeroContacto;
    private Boolean estado;

    public Long getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(Long idDelivery) {
        this.idDelivery = idDelivery;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
