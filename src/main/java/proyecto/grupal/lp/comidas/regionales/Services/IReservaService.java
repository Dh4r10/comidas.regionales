package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Reserva;

import java.util.List;
import java.util.Optional;

public interface IReservaService {

    List<Reserva> getAllReservas();
    Optional<Reserva> getReservaById(Long id);
    void postReserva(Reserva request);
    Reserva putReserva(Reserva request, Long id);
    void deleteReserva(Long id);

}
