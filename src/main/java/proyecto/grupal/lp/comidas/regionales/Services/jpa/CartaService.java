package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Carta;
import proyecto.grupal.lp.comidas.regionales.Repositories.CartaRepository;
import proyecto.grupal.lp.comidas.regionales.Services.ICartaService;

import java.util.List;
import java.util.Optional;

@Service
public class CartaService implements ICartaService {

    @Autowired
    private CartaRepository cartaRepository;

    public List<Carta> getAllCartas(){
        return cartaRepository.findAll();
    }

    public Optional<Carta> getCartaById(Long id){
        return cartaRepository.findById(id);
    }

    public void postCarta(Carta request){

        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        cartaRepository.save(request);

    }

    public Carta putCarta(Carta request, Long id){
        Carta carta = cartaRepository.findById(id).get();

        carta.setNombre(request.getNombre());

        if (request.getEstado() == null) {
            carta.setEstado(carta.getEstado());
        } else {
            carta.setEstado(request.getEstado());
        }

        return cartaRepository.save(carta);
    }

    public Carta patchCarta(Carta request, Long id){
        Carta carta = cartaRepository.findById(id).get();

        if (request.getNombre() == null) {
            carta.setNombre(carta.getNombre());
        } else {
            carta.setNombre(request.getNombre());
        }

        if (request.getEstado() == null) {
            carta.setEstado(carta.getEstado());
        } else {
            carta.setEstado(request.getEstado());
        }

        return cartaRepository.save(carta);
    }

    public void deleteCarta(Long id){
        cartaRepository.deleteById(id);
    }

}
