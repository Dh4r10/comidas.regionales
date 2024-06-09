package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.DetalleReserva;
import proyecto.grupal.lp.comidas.regionales.Repositories.DetalleReservaRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IDetalleReservaService;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleReservaService implements IDetalleReservaService {

    @Autowired
    private DetalleReservaRepository detalleReservaRepository;

    public List<DetalleReserva> getAllDetalleReservas() {
        return detalleReservaRepository.findAll();
    }

    public Optional<DetalleReserva> getDetalleReservaById(Long id) {
        return detalleReservaRepository.findById(id);
    }

    public void postDetalleReserva(DetalleReserva request) {
        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        detalleReservaRepository.save(request);
    }

    public DetalleReserva putDetalleReserva(DetalleReserva request, Long id) {
        DetalleReserva detalleReserva = detalleReservaRepository.findById(id).get();

        detalleReserva.setReserva(request.getReserva());
        detalleReserva.setMesa(request.getMesa());

        if (request.getEstado() == null) {
            detalleReserva.setEstado(detalleReserva.getEstado());
        } else {
            detalleReserva.setEstado(request.getEstado());
        }

        return detalleReservaRepository.save(detalleReserva);
    }

    public void deleteDetalleReserva(Long id) {
        detalleReservaRepository.deleteById(id);
    }
}
