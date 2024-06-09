package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.DetallePedidoMesa;

import java.util.List;
import java.util.Optional;

public interface IDetallePedidoMesaService {

    List<DetallePedidoMesa> getAllDetallePedidoMesas();
    Optional<DetallePedidoMesa> getDetallePedidoMesaById(Long id);
    void postDetallePedidoMesa(DetallePedidoMesa request);
    DetallePedidoMesa putDetallePedidoMesa(DetallePedidoMesa request, Long id);
    void deleteDetallePedidoMesa(Long id);

}
