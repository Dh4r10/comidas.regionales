package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Mesa;

import java.util.List;
import java.util.Optional;

public interface IMesaService {

    List<Mesa> getAllMesas();
    Optional<Mesa> getMesaById(Long id);
    void postMesa(Mesa request);
    Mesa putMesa(Mesa request, Long id);
    void deleteMesa(Long id);

}
