package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.MovimientoInsumo;

import java.util.List;
import java.util.Optional;

public interface IMovimientoInsumoService {
    List<MovimientoInsumo> getMovimientoInsumo();
    Optional<MovimientoInsumo> ObtenerMovimientoInsumo(Long id);
    void GuardarMovimientoInsumo(MovimientoInsumo movimientoInsumo);
    MovimientoInsumo ActualizarMovimientoInsumo(MovimientoInsumo movimientoInsumo,Long id);
    void EliminarMovimientoInsumo(Long id);
}

