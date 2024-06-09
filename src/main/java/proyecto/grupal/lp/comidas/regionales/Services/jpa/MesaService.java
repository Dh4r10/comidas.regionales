package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Mesa;
import proyecto.grupal.lp.comidas.regionales.Repositories.MesaRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IMesaService;

import java.util.List;
import java.util.Optional;

@Service
public class MesaService implements IMesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll();
    }

    public Optional<Mesa> getMesaById(Long id) {
        return mesaRepository.findById(id);
    }

    public void postMesa(Mesa request) {
        if (request.getReservado() == null) {
            request.setReservado(false);
        }

        if (request.getOcupado() == null) {
            request.setOcupado(false);
        }

        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        mesaRepository.save(request);
    }

    public Mesa putMesa(Mesa request, Long id) {
        Mesa mesa = mesaRepository.findById(id).get();

        mesa.setArea(request.getArea());
        mesa.setTipoMesa(request.getTipoMesa());
        mesa.setNumero(request.getNumero());
        mesa.setCapacidad(request.getCapacidad());

        if (request.getReservado() == null) {
            mesa.setReservado(mesa.getReservado());
        } else {
            mesa.setReservado(request.getReservado());
        }

        if (request.getOcupado() == null) {
            mesa.setOcupado(mesa.getOcupado());
        } else {
            mesa.setOcupado(request.getOcupado());
        }

        if (request.getEstado() == null) {
            mesa.setEstado(mesa.getEstado());
        } else {
            mesa.setEstado(request.getEstado());
        }

        return mesaRepository.save(mesa);
    }

    public void deleteMesa(Long id) {
        mesaRepository.deleteById(id);
    }

}
