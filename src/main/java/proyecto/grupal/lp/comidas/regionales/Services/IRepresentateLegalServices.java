package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.RepresentanteLegal;

import java.util.List;
import java.util.Optional;

public interface IRepresentateLegalServices {

    List<RepresentanteLegal> getRepresentanteLegal();
    Optional<RepresentanteLegal> getRepresentanteLegalById(Long id);
    void postRepresentanteLegal(RepresentanteLegal representanteLegal);
    RepresentanteLegal putRepresentanteLegal(RepresentanteLegal representanteLegal,Long id);
    void deleteRepresentanteLegal(Long id);
}
