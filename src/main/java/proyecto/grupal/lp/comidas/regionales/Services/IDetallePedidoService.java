package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.DetallePedido;

import java.util.List;
import java.util.Optional;

public interface IDetallePedidoService {

    List<DetallePedido> getAllDetallePedidos();
    Optional<DetallePedido> getDetallePedidoById(Long id);
    DetallePedido postDetallePedido(DetallePedido request);
    DetallePedido putDetallePedido(DetallePedido request, Long id);
    void deleteDetallePedido(Long id);

}
