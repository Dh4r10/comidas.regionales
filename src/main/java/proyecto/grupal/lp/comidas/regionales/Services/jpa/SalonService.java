package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Salon;
import proyecto.grupal.lp.comidas.regionales.Repositories.SalonRepository;
import proyecto.grupal.lp.comidas.regionales.Services.ISalonService;

import java.util.List;
import java.util.Optional;

@Service
public class SalonService implements ISalonService {

    @Autowired
    private SalonRepository salonRepository;

    public List<Salon> getAllSalones() {
        return salonRepository.findAll();
    }

    public Optional<Salon> getSalonById(Long id) {
        return salonRepository.findById(id);
    }

    public void postSalon(Salon request) {

        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        salonRepository.save(request);
    }

    public Salon putSalon(Salon request, Long id) {
        Salon salon = salonRepository.findById(id).get();

        salon.setPiso(request.getPiso());
        salon.setNombre(request.getNombre());
        salon.setAforo(request.getAforo());

        if (request.getEstado() == null) {
            salon.setEstado(salon.getEstado());
        } else {
            salon.setEstado(request.getEstado());
        }

        return salonRepository.save(salon);

    }

    public Salon patchSalon(Salon request, Long id) {
        Salon salon = salonRepository.findById(id).get();

        if (request.getPiso() == null) {
            salon.setPiso(salon.getPiso());
        } else {
            salon.setPiso(request.getPiso());
        }

        if (request.getNombre() == null) {
            salon.setNombre(salon.getNombre());
        } else {
            salon.setNombre(request.getNombre());
        }

        if (request.getAforo() == null) {
            salon.setAforo(salon.getAforo());
        } else {
            salon.setAforo(request.getAforo());
        }

        if (request.getEstado() == null) {
            salon.setEstado(salon.getEstado());
        } else {
            salon.setEstado(request.getEstado());
        }

        return salonRepository.save(salon);
    }

    public void deleteSalon(Long id) {
        salonRepository.deleteById(id);
    }

}
