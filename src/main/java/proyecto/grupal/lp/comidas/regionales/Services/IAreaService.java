package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Area;

import java.util.List;
import java.util.Optional;

public interface IAreaService {

    List<Area> getAllAreas(Long idSalon);
    Optional<Area> getAreaById(Long id);
    void postArea(Area request);
    Area putArea(Area request, Long id);
    Area patchArea(Area request, Long id);
    void deleteArea(Long id);

}
