package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Establecimiento;

import java.util.List;
import java.util.Optional;

public interface IEstableciminetoServices {

    List<Establecimiento> getEstablecimiento();
    Optional<Establecimiento> getEstablecimientoCondicionado(Long idE);
    Optional<Establecimiento> getEstablecimientoId(Long id);
    void postEstablecimiento(Establecimiento establecimiento);
    Establecimiento putEstablecimiento(Establecimiento establecimiento,Long id);
    void  deleteEstablecimiento(Long id);



}
