package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Reserva;
import proyecto.grupal.lp.comidas.regionales.Repositories.ReservaRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IReservaService;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService implements IReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> getReservaById(Long id) {
        return reservaRepository.findById(id);
    }

    public void postReserva(Reserva request) {
        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        reservaRepository.save(request);
    }

    public Reserva putReserva(Reserva request, Long id) {
        Reserva reserva = reservaRepository.findById(id).get();

        reserva.setNumeroPersonas(request.getNumeroPersonas());
        reserva.setFechaReserva(request.getFechaReserva());
        reserva.setHoraReserva(request.getHoraReserva());
        reserva.setProrroga(request.getProrroga());

        if (reserva.getEstado() == null) {
            reserva.setEstado(reserva.getEstado());
        } else {
            reserva.setEstado(request.getEstado());
        }

        return reservaRepository.save(reserva);
    }

    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }

}
