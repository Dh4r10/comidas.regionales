package proyecto.grupal.lp.comidas.regionales.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import proyecto.grupal.lp.comidas.regionales.Entities.Mesa;

public class DetalleMesaDto {

    @JsonProperty("id")
    private Long idDetalleMesa;

    private Long idPedido;
    private Long idMesa;

    private Boolean estado;

    public Long getIdDetalleMesa() {
        return idDetalleMesa;
    }

    public void setIdDetalleMesa(Long idDetalleMesa) {
        this.idDetalleMesa = idDetalleMesa;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
