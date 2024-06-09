package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Apertura;

import java.util.List;
import java.util.Optional;

public interface IAperturaServices {

    List<Apertura> getAperturas();
    Optional<Apertura> getAperturaById(Long id);
    void postApertura(Apertura apertura);
    Apertura putApertura(Long id, Apertura apertura);
    void deleteApertura(Long id);

}
