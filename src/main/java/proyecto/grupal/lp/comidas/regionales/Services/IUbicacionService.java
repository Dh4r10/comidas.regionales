package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Ubicacion;

import java.util.List;
import java.util.Optional;

public interface IUbicacionService {
    List<Ubicacion> getUbicacion();
    Optional<Ubicacion> ObtenerUbicacion(Long id);
    void GuardarUbicacion(Ubicacion ubicacion);
    Ubicacion ActualizarUbicacion(Ubicacion ubicacion,Long id);
    void EliminarUbicacion(Long id);
}