package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Carta;

import java.util.List;
import java.util.Optional;

public interface ICartaService {

    List<Carta> getAllCartas();
    Optional<Carta> getCartaById(Long id);
    void postCarta(Carta request);
    Carta putCarta(Carta request, Long id);
    Carta patchCarta(Carta request, Long id);
    void deleteCarta(Long id);

}
