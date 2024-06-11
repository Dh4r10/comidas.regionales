package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto.grupal.lp.comidas.regionales.Dto.DetallePedidoPostRequest;
import proyecto.grupal.lp.comidas.regionales.Entities.*;
import proyecto.grupal.lp.comidas.regionales.Repositories.*;
import proyecto.grupal.lp.comidas.regionales.Services.IDetallePedidoService;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService implements IDetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private MesaRepository mesaRepository;
    @Autowired
    private DetalleMesaRepository detalleMesaRepository;
    @Autowired
    private DeliveryRepository deliveryRepository;

    public List<DetallePedido> getAllDetallePedidos() {
        return detallePedidoRepository.findAll();
    }

    public Optional<DetallePedido> getDetallePedidoById(Long id) {
        return detallePedidoRepository.findById(id);
    }

    @Transactional
    public Pedido postDetallePedido(DetallePedidoPostRequest request) {
        Pedido pedido = new Pedido();

        pedido.setFecha(request.getFecha());
        pedido.setTipoPedido(request.getTipoPedido());
        pedido.setEstado(true);

        Pedido pedidoGuardado = pedidoRepository.save(pedido);

        request.getListaPedidos().stream().map(detallePedidoDto -> {
            DetallePedido detallePedido = new DetallePedido();
            Producto producto = productoRepository.findById(detallePedidoDto.getIdProducto()).orElseThrow();
            detallePedido.setProducto(producto);
            detallePedido.setPedido(pedidoGuardado);
            detallePedido.setCantidad(detallePedidoDto.getCantidad());
            detallePedido.setDescripcion(detallePedidoDto.getDescripcion());
            detallePedido.setEstado(true);

            return detallePedidoRepository.save(detallePedido);
        }).toList();

        if (pedidoGuardado.getTipoPedido().equals("SALON")) {
            request.getListaMesas().stream().map(detalleMesaDtoCopia -> {
                DetalleMesa detalleMesa = new DetalleMesa();
                Mesa mesa = mesaRepository.findById(detalleMesaDtoCopia.getIdMesa()).orElseThrow();
                detalleMesa.setMesa(mesa);
                detalleMesa.setPedido(pedidoGuardado);
                detalleMesa.setEstado(true);

                mesa.setOcupado(true);

                return detalleMesaRepository.save(detalleMesa);
            }).toList();
        } else if (pedidoGuardado.getTipoPedido().equals("DELIVERY")) {
            Delivery delivery = new Delivery();
            delivery.setPedido(pedidoGuardado);
            delivery.setDireccion(request.getDireccion());
            delivery.setNumeroContacto(request.getNumeroContacto());
            delivery.setEstado(true);

            return deliveryRepository.save(delivery).getPedido();
        }

        return pedidoGuardado;
    }

    public DetallePedido putDetallePedido(DetallePedido request, Long id) {
        DetallePedido detallePedido = detallePedidoRepository.findById(id).get();

        detallePedido.setPedido(request.getPedido());
        detallePedido.setProducto(request.getProducto());
        detallePedido.setDescripcion(request.getDescripcion());
        detallePedido.setCantidad(request.getCantidad());

        if (request.getEstado() == null) {
            detallePedido.setEstado(detallePedido.getEstado());
        } else {
            detallePedido.setEstado(request.getEstado());
        }

        return detallePedidoRepository.save(detallePedido);

    }

    public void deleteDetallePedido(Long id) {
        detallePedidoRepository.deleteById(id);
    }

}
