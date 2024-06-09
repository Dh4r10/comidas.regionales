package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Almacen;

import java.util.List;
import java.util.Optional;

public interface IAlmacenService {
    List<Almacen> getAlmacen();
    Optional<Almacen> ObtenerAlmacen(Long id);
    void GuardarAlmacen(Almacen almacen);
    Almacen ActualizarAlmacen(Almacen almacen,Long id);
    void EliminarAlmacen(Long id);
}

