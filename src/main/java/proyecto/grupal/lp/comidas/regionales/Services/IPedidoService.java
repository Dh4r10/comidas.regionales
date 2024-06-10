package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Dto.PedidoDtoGetRequest;
import proyecto.grupal.lp.comidas.regionales.Entities.Pedido;
import proyecto.grupal.lp.comidas.regionales.Dto.PedidoDtoPostRequest;

import java.util.List;

public interface IPedidoService {

    List<Pedido> getAllPedidos();
    PedidoDtoGetRequest getPedidoById(Long id);
    Pedido postPedido(PedidoDtoPostRequest request);
    Pedido putPedido(Pedido request, Long id);
    void deletePedido(Long id);

}
