package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto.grupal.lp.comidas.regionales.Entities.DetallePedido;
import proyecto.grupal.lp.comidas.regionales.Entities.Pedido;
import proyecto.grupal.lp.comidas.regionales.Entities.PedidoDtoRequest;
import proyecto.grupal.lp.comidas.regionales.Entities.Producto;
import proyecto.grupal.lp.comidas.regionales.Repositories.DetallePedidoRepository;
import proyecto.grupal.lp.comidas.regionales.Repositories.PedidoRepository;
import proyecto.grupal.lp.comidas.regionales.Repositories.ProductoRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IPedidoService;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> getPedidoById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Transactional
    public Pedido postPedido(PedidoDtoRequest request) {
        Pedido pedido = new Pedido();

        pedido.setFecha(request.getFecha());
        pedido.setTipoPedido(request.getTipoPedido());
        pedido.setEstado(true);

        Pedido pedidoGuardado = pedidoRepository.save(pedido);

        List<DetallePedido> detallePedidos = request.getListaPedido().stream().map(pedidoDto -> {
            DetallePedido detallePedido = new DetallePedido();
            Producto producto = productoRepository.findById(pedidoDto.getProductoId()).orElseThrow();
            detallePedido.setProducto(producto);
            detallePedido.setPedido(pedidoGuardado);
            detallePedido.setEstado(true);
            detallePedido.setCantidad(pedidoDto.getCantidad());
            detallePedido.setDescripcion(pedidoDto.getDescripcion());
            System.out.println("entrando");

            return detallePedidoRepository.save(detallePedido);
        }).toList();

        pedidoGuardado.setDetallePedido(detallePedidos);
        return pedidoGuardado;
    }

    public Pedido putPedido(Pedido request, Long id) {
        Pedido pedido = pedidoRepository.findById(id).get();

        pedido.setFecha(request.getFecha());
        pedido.setTipoPedido(request.getTipoPedido());

        if (request.getEstado() == null) {
            pedido.setEstado(pedido.getEstado());
        } else {
            pedido.setEstado(request.getEstado());
        }

        return pedidoRepository.save(pedido);
    }

    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }

}
