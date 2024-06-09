package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Seccion;

import java.util.List;
import java.util.Optional;

public interface ISeccionService {

    List<Seccion> getAllSecciones();
    Optional<Seccion> getSeccionById(Long id);
    void postSeccion(Seccion request);
    Seccion putSeccion(Seccion request, Long id);
    Seccion patchSeccion(Seccion request, Long id);
    void deleteSeccion(Long id);

}
