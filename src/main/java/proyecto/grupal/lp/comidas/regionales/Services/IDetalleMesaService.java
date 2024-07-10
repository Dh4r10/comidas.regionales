package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Dto.DetalleMesaGetDto;
import proyecto.grupal.lp.comidas.regionales.Entities.DetalleMesa;
import proyecto.grupal.lp.comidas.regionales.Entities.Pedido;

import java.util.List;
import java.util.Optional;

public interface IDetalleMesaService {

    List<DetalleMesa> getAllDetallePedidoMesas();
    List<DetalleMesaGetDto> getPedidoPorMesa(Long idMesa);
    Optional<DetalleMesa> getDetallePedidoMesaById(Long id);
    void postDetallePedidoMesa(DetalleMesa request);
    DetalleMesa putDetallePedidoMesa(DetalleMesa request, Long id);
    void deleteDetallePedidoMesa(Long id);

}
