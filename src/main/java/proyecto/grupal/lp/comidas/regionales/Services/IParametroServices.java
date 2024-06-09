package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Parametros;

import java.util.List;
import java.util.Optional;

public interface IParametroServices {

    List<Parametros> getParametros();
    Optional<Parametros> getParametrosById(Long id);
    void postParametros(Parametros parametros);
    Parametros putParametros(Parametros parametros,Long id);
    void deleteParametros(Long id);
}
