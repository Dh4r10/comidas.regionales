package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Estaticas;

import java.util.List;
import java.util.Optional;


public interface IEstaticasServices {

    List<Estaticas> getEstaticas();
    Optional<Estaticas> getEstaticasById(Long id);
    void postEstaticas(Estaticas estaticas);
    Estaticas putEstaticas(Estaticas estaticas,Long id);
    void deleteEstaticas(Long id);
}
