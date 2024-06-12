package proyecto.grupal.lp.comidas.regionales.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetalleMesaMesaDto {

    @JsonProperty("id")
    private Long detalleMesaId;

    private Long mesaId;
    private Long areaId;
    private String tipoMesa;
    private Integer numero;
    private Integer capacidad;

    public Long getDetalleMesaId() {
        return detalleMesaId;
    }

    public void setDetalleMesaId(Long detalleMesaId) {
        this.detalleMesaId = detalleMesaId;
    }

    public Long getMesaId() {
        return mesaId;
    }

    public void setMesaId(Long mesaId) {
        this.mesaId = mesaId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getTipoMesa() {
        return tipoMesa;
    }

    public void setTipoMesa(String tipoMesa) {
        this.tipoMesa = tipoMesa;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
}
