package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Area;
import proyecto.grupal.lp.comidas.regionales.Repositories.AreaRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IAreaService;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService implements IAreaService {

    @Autowired
    private AreaRepository areaRepository;

    public List<Area> getAllAreas(Long idSalon) {
        return areaRepository.findAll().stream().filter(
                a -> a.getSalon().getId() == idSalon
        ).toList();
    }

    public Optional<Area> getAreaById(Long id) {
        return areaRepository.findById(id);
    }

    public void postArea(Area request) {

        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        areaRepository.save(request);

    }

    public Area putArea(Area request, Long id) {
        Area area = areaRepository.findById(id).get();

        area.setSalon(request.getSalon());
        area.setNombre(request.getNombre());
        area.setDescripcion(request.getDescripcion());

        if (request.getEstado() != null) {
            area.setEstado(area.getEstado());
        } else {
            area.setEstado(request.getEstado());
        }

        return areaRepository.save(area);
    }

    public Area patchArea(Area request, Long id) {
        Area area = areaRepository.findById(id).get();

        if (request.getSalon() == null) {
            area.setSalon(area.getSalon());
        } else {
            area.setSalon(request.getSalon());
        }

        if (request.getNombre() == null) {
            area.setNombre(area.getNombre());
        } else {
            area.setNombre(request.getNombre());
        }

        if (request.getDescripcion() == null) {
            area.setDescripcion(area.getDescripcion());
        } else {
            area.setDescripcion(request.getDescripcion());
        }

        if (request.getEstado() == null) {
            area.setEstado(area.getEstado());
        } else {
            area.setEstado(request.getEstado());
        }

        return areaRepository.save(area);
    }

    public void deleteArea(Long id) {
        areaRepository.deleteById(id);
    }

}
