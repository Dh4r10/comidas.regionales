package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Responsable;

import java.util.List;
import java.util.Optional;

public interface IResponsableServices {

    List<Responsable> getResponsable();
    Optional<Responsable> getResponsableId(Long id);
    void postResponsable(Responsable responsable);
    Responsable putResponsable(Responsable responsable,Long id);
    void delteResponsable(Long id);
}
