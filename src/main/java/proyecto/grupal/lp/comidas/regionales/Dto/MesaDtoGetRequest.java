package proyecto.grupal.lp.comidas.regionales.Dto;

import java.util.List;

public class MesaDtoGetRequest {
    List <SalonDto> salones;
    List <AreaDto> areas;
    List <MesaDto> mesas;

    public List<SalonDto> getSalones() {
        return salones;
    }

    public void setSalones(List<SalonDto> salones) {
        this.salones = salones;
    }

    public List<AreaDto> getAreas() {
        return areas;
    }

    public void setAreas(List<AreaDto> areas) {
        this.areas = areas;
    }

    public List<MesaDto> getMesas() {
        return mesas;
    }

    public void setMesas(List<MesaDto> mesas) {
        this.mesas = mesas;
    }
}
