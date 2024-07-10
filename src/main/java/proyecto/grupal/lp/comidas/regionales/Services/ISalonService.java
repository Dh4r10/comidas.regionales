package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Salon;

import java.util.List;
import java.util.Optional;

public interface ISalonService {

    List<Salon> getAllSalones(Long idSucursal);
    Optional<Salon> getSalonById(Long id);
    void postSalon(Salon request);
    Salon putSalon(Salon request, Long id);
    Salon patchSalon(Salon request, Long id);
    void deleteSalon(Long id);
}
