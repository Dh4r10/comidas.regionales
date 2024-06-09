package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Insumo;

import java.util.List;
import java.util.Optional;

public interface IInsumoService {
    List<Insumo> getInsumo();
    Optional<Insumo> ObtenerInsumo(Long id);
    void GuardarInsumo(Insumo insumo);
    Insumo ActualizarInsumo(Insumo insumo,Long id);
    void EliminarInsumo(Long id);
}

