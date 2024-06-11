package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Dto.DetallePedidoPostRequest;
import proyecto.grupal.lp.comidas.regionales.Entities.DetallePedido;
import proyecto.grupal.lp.comidas.regionales.Entities.Pedido;

import java.util.List;
import java.util.Optional;

public interface IDetallePedidoService {

    List<DetallePedido> getAllDetallePedidos();
    Optional<DetallePedido> getDetallePedidoById(Long id);
    Pedido postDetallePedido(DetallePedidoPostRequest request);
    DetallePedido putDetallePedido(DetallePedido request, Long id);
    void deleteDetallePedido(Long id);

}
