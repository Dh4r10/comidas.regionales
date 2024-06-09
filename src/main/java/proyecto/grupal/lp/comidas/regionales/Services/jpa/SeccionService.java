package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Seccion;
import proyecto.grupal.lp.comidas.regionales.Repositories.SeccionRepository;
import proyecto.grupal.lp.comidas.regionales.Services.ISeccionService;

import java.util.List;
import java.util.Optional;

@Service
public class SeccionService implements ISeccionService {

    @Autowired
    private SeccionRepository seccionRepository;

    public List<Seccion> getAllSecciones() {
        return seccionRepository.findAll();
    }

    public Optional<Seccion> getSeccionById(Long id) {
        return seccionRepository.findById(id);
    }

    public void postSeccion(Seccion request) {

        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        seccionRepository.save(request);
    }

    public Seccion putSeccion(Seccion request, Long id) {
        Seccion seccion = seccionRepository.findById(id).get();

        seccion.setCarta(request.getCarta());
        seccion.setNombre(request.getNombre());

        if (request.getEstado() == null) {
            seccion.setEstado(seccion.getEstado());
        } else {
            seccion.setEstado(request.getEstado());
        }

        return seccionRepository.save(seccion);
    }

    public Seccion patchSeccion(Seccion request, Long id) {
        Seccion seccion = seccionRepository.findById(id).get();

        if (request.getCarta() == null) {
            seccion.setCarta(seccion.getCarta());
        } else {
            seccion.setCarta(request.getCarta());
        }

        if (request.getNombre() == null) {
            seccion.setNombre(seccion.getNombre());
        } else {
            seccion.setNombre(request.getNombre());
        }

        if (request.getEstado() == null) {
            seccion.setEstado(seccion.getEstado());
        } else {
            seccion.setEstado(request.getEstado());
        }

        return seccionRepository.save(seccion);
    }

    public void deleteSeccion(Long id) {
        seccionRepository.deleteById(id);
    }

}
