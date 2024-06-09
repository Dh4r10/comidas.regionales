package proyecto.grupal.lp.comidas.regionales.Services;


import proyecto.grupal.lp.comidas.regionales.Entities.MovimientoAdicional;

import java.util.List;
import java.util.Optional;

public interface IMovimientoAdicionalServices {

    List<MovimientoAdicional> getMovimientoAdicional();
    Optional<MovimientoAdicional> getMovimientoAdicionalById(Long id);
    void postMovimientoAdicional(MovimientoAdicional movimientoAdicional);
    MovimientoAdicional putMovimientoAdicional(MovimientoAdicional movimientoAdicional,Long id);
    void deleteMovimientoAdicional(Long id);
}
