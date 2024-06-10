package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.DetalleMesa;

import java.util.List;
import java.util.Optional;

public interface IDetalleMesaService {

    List<DetalleMesa> getAllDetallePedidoMesas();
    Optional<DetalleMesa> getDetallePedidoMesaById(Long id);
    void postDetallePedidoMesa(DetalleMesa request);
    DetalleMesa putDetallePedidoMesa(DetalleMesa request, Long id);
    void deleteDetallePedidoMesa(Long id);

}
