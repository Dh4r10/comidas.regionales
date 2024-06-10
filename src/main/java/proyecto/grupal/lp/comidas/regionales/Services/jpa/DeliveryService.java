package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Dto.DeliveryGetRequestDto;
import proyecto.grupal.lp.comidas.regionales.Dto.DetallePedidoDto;
import proyecto.grupal.lp.comidas.regionales.Entities.Delivery;
import proyecto.grupal.lp.comidas.regionales.Entities.DetallePedido;
import proyecto.grupal.lp.comidas.regionales.Entities.Pedido;
import proyecto.grupal.lp.comidas.regionales.Repositories.DeliveryRepository;
import proyecto.grupal.lp.comidas.regionales.Repositories.DetallePedidoRepository;
import proyecto.grupal.lp.comidas.regionales.Repositories.PedidoRepository;
import proyecto.grupal.lp.comidas.regionales.Repositories.VentaRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IDeliveryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService implements IDeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;
    
    @Autowired
    private VentaRepository ventaRepository;

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public DeliveryGetRequestDto getDeliveryById(Long id) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        
        List<DetallePedido> detallePedido = detallePedidoRepository.findAll();
        List<DetallePedidoDto> listaPedidos = new ArrayList<>();

        long pedidoId = delivery.get().getPedido().getId();
        Optional<Pedido> pedido = pedidoRepository.findById(pedidoId);

        boolean ventaExiste = ventaRepository.existsByPedidoId(pedidoId);
        long numPedidos = detallePedidoRepository.countIdByDetallePedido(pedidoId);
        long contador = 0;

        DeliveryGetRequestDto deliveryBoleta = new DeliveryGetRequestDto();
        deliveryBoleta.setIdPedido(pedidoId);
        deliveryBoleta.setTipoPedido(pedido.get().getTipoPedido());
        deliveryBoleta.setNumContacto(delivery.get().getNumeroContacto());
        deliveryBoleta.setDireccion(delivery.get().getDireccion());
        deliveryBoleta.setFecha(pedido.get().getFecha());
        deliveryBoleta.setEstadoPedido(ventaExiste ? "ENTREGADO" : "PENDIENTE");

        for (DetallePedido value : detallePedido) {
            if (numPedidos > contador) {
                    if (value.getPedido().getId() == pedidoId) {
                    DetallePedidoDto detallePedidoDto = new DetallePedidoDto();
                    detallePedidoDto.setProductoId(value.getProducto().getId());
                    detallePedidoDto.setNombreProducto(value.getProducto().getNombre());
                    detallePedidoDto.setDescripcionProducto(value.getProducto().getDescripcion());
                    detallePedidoDto.setPrecioProducto(value.getProducto().getPrecio());
                    detallePedidoDto.setImagenProducto(value.getProducto().getImagen());
                    detallePedidoDto.setDescripcion(value.getProducto().getDescripcion());
                    detallePedidoDto.setCantidad(value.getCantidad());

                    listaPedidos.add(detallePedidoDto);

                    contador ++;
                }
            } else {
                break;
            }
        }

        deliveryBoleta.setListaPedidos(listaPedidos);

        return deliveryBoleta;
    }

    public void postDelivery(Delivery request) {

        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        deliveryRepository.save(request);
    }

    public Delivery putDelivery(Delivery request, Long id ) {
        Delivery delivery = deliveryRepository.findById(id).get();

        delivery.setPedido(request.getPedido());
        delivery.setDireccion(request.getDireccion());
        delivery.setNumeroContacto(request.getNumeroContacto());

        if (request.getEstado() == null) {
            delivery.setEstado(delivery.getEstado());
        } else {
            delivery.setEstado(request.getEstado());
        }

        return deliveryRepository.save(delivery);
    }

    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }

}
