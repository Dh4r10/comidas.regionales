package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Caja;

import java.util.List;
import java.util.Optional;

public interface ICajaServices {
    List<Caja> getCaja();
    Optional<Caja> getCajaById(Long id);
    void postCaja(Caja caja);
    Caja putCaja(Long id,Caja caja);
    void deleteCaja(Long id);
}
