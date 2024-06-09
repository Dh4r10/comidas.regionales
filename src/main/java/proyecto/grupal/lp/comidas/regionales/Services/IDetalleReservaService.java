package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.DetalleReserva;

import java.util.List;
import java.util.Optional;

public interface IDetalleReservaService {

    List<DetalleReserva> getAllDetalleReservas();
    Optional<DetalleReserva> getDetalleReservaById(Long id);
    void postDetalleReserva(DetalleReserva request);
    DetalleReserva putDetalleReserva(DetalleReserva request, Long id);
    void deleteDetalleReserva(Long id);

}
