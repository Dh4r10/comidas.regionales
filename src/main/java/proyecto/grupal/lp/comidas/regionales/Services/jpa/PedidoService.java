package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto.grupal.lp.comidas.regionales.Dto.DetalleMesaDtoCopia;
import proyecto.grupal.lp.comidas.regionales.Dto.DetallePedidoDtoCopia;
import proyecto.grupal.lp.comidas.regionales.Dto.PedidoDtoGetRequest;
import proyecto.grupal.lp.comidas.regionales.Entities.*;
import proyecto.grupal.lp.comidas.regionales.Dto.PedidoDtoPostRequest;
import proyecto.grupal.lp.comidas.regionales.Repositories.*;
import proyecto.grupal.lp.comidas.regionales.Services.IPedidoService;

import java.util.*;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DetalleMesaRepository detalleMesaRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private VentaRepository ventaRepository;

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll().stream().filter(pedido -> "SALON".equals(pedido.getTipoPedido())).toList();
    }

    public Optional<Pedido> getPedidoById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Transactional
    public Pedido postPedido(PedidoDtoPostRequest request) {
        Pedido pedido = new Pedido();

        pedido.setFecha(request.getFecha());
        pedido.setTipoPedido(request.getTipoPedido());
        pedido.setEstado(true);

        Pedido pedidoGuardado = pedidoRepository.save(pedido);

        request.getListaPedido().stream().map(detallePedidoDto -> {
            DetallePedido detallePedido = new DetallePedido();
            Producto producto = productoRepository.findById(detallePedidoDto.getProductoId()).orElseThrow();
            detallePedido.setProducto(producto);
            detallePedido.setPedido(pedidoGuardado);
            detallePedido.setEstado(true);
            detallePedido.setCantidad(detallePedidoDto.getCantidad());
            detallePedido.setDescripcion(detallePedidoDto.getDescripcion());

            return detallePedidoRepository.save(detallePedido);
        }).toList();

        if (pedidoGuardado.getTipoPedido().equals("SALON")) {
            request.getListaMesa().stream().map(detalleMesaDtoCopia -> {
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
