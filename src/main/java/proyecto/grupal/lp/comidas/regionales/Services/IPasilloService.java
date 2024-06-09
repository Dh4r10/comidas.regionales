package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Pasillo;

import java.util.List;
import java.util.Optional;

public interface IPasilloService {
    List<Pasillo> getPasillo();
    Optional<Pasillo> ObtenerPasillo(Long id);
    void GuardarPasillo(Pasillo pasillo);
    Pasillo ActualizarPasillo(Pasillo pasillo,Long id);
    void EliminarPasillo(Long id);
}