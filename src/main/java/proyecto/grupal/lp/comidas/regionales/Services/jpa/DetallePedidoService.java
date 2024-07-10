package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto.grupal.lp.comidas.regionales.Dto.*;
import proyecto.grupal.lp.comidas.regionales.Entities.*;
import proyecto.grupal.lp.comidas.regionales.Repositories.*;
import proyecto.grupal.lp.comidas.regionales.Services.IDetallePedidoService;

import java.util.ArrayList;
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
    @Autowired
    private VentaRepository ventaRepository;

    public List<DetallePedido> getAllDetallePedidos() {
        return detallePedidoRepository.findAll();
    }

    public Optional<DetallePedido> getDetallePedidoById(Long id) {
        return detallePedidoRepository.findById(id);
    }

    public DetallePedidoSalonGetRequest getDetallePedidoSalonById(Long id) {

        Optional<Pedido> pedido = pedidoRepository.pedidoSalonById("SALON", id);

        Long idPedido = pedido.get().getId();

        List<DetallePedido> detallePedido = detallePedidoRepository.detallePedidoPorPedido(idPedido);
        List<DetallePedidoProductoDto> listaPedidos = new ArrayList<>();
        
        List<DetalleMesa> detalleMesa = detalleMesaRepository.detalleMesaPorPedido(idPedido);
        List<DetalleMesaMesaDto> listaMesas = new ArrayList<>();

        boolean ventaExiste = ventaRepository.existsByPedidoId(pedido.get().getId());

        DetallePedidoSalonGetRequest detallePedidoSalonGetRequest = new DetallePedidoSalonGetRequest();
        detallePedidoSalonGetRequest.setPedidoId(pedido.get().getId());
        detallePedidoSalonGetRequest.setFecha(pedido.get().getFecha());
        detallePedidoSalonGetRequest.setTipoPedido(pedido.get().getTipoPedido());
        detallePedidoSalonGetRequest.setEstadoPedido(ventaExiste ? "PAGADO" : "PENDIENTE");

        for (DetallePedido value : detallePedido) {
            DetallePedidoProductoDto detallePedidoProductoDto = new DetallePedidoProductoDto();
            detallePedidoProductoDto.setDetallePedidoId(value.getId());
            detallePedidoProductoDto.setProductoId(value.getProducto().getId());
            detallePedidoProductoDto.setTipoProducto(value.getProducto().getTipoProducto());
            detallePedidoProductoDto.setNombreProducto(value.getProducto().getNombre());
            detallePedidoProductoDto.setDescripcionProducto(value.getProducto().getDescripcion());
            detallePedidoProductoDto.setPrecioProducto(value.getProducto().getPrecio());
            detallePedidoProductoDto.setImagenProducto(value.getProducto().getImagen());
            detallePedidoProductoDto.setDescripcion(value.getDescripcion());
            detallePedidoProductoDto.setCantidad(value.getCantidad());

            listaPedidos.add(detallePedidoProductoDto);
        }

        detallePedidoSalonGetRequest.setProductos(listaPedidos);

        for (DetalleMesa value : detalleMesa) {
            DetalleMesaMesaDto detalleMesaMesaDto = new DetalleMesaMesaDto();
            detalleMesaMesaDto.setDetalleMesaId(value.getId());
            detalleMesaMesaDto.setMesaId(value.getMesa().getId());
            detalleMesaMesaDto.setAreaId(value.getMesa().getArea().getId());
            detalleMesaMesaDto.setTipoMesa(value.getMesa().getTipoMesa());
            detalleMesaMesaDto.setNumero(value.getMesa().getNumero());
            detalleMesaMesaDto.setCapacidad(value.getMesa().getCapacidad());

            listaMesas.add(detalleMesaMesaDto);
        }

        detallePedidoSalonGetRequest.setMesas(listaMesas);

        return detallePedidoSalonGetRequest;
    }

    public DetallePedidoDeliveryGetRequest getDetallePedidoDeliveryById(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id).filter(pedido1 -> pedido1.getTipoPedido().equals("DELIVERY"));
        Optional<Delivery> delivery = deliveryRepository.findById(pedido.get().getDelivery().getId());

        List<DetallePedido> detallePedido = detallePedidoRepository.findAll();
        List<DetallePedidoProductoDto> listaPedidos = new ArrayList<>();

        boolean ventaExiste = ventaRepository.existsByPedidoId(pedido.get().getId());
        long numPedidos = detallePedidoRepository.countIdByDetallePedido(pedido.get().getId());
        long contador = 0;

        DetallePedidoDeliveryGetRequest detallePedidoDeliveryGetRequest = new DetallePedidoDeliveryGetRequest();
        detallePedidoDeliveryGetRequest.setPedidoId(pedido.get().getId());
        detallePedidoDeliveryGetRequest.setFecha(pedido.get().getFecha());
        detallePedidoDeliveryGetRequest.setTipoPedido(pedido.get().getTipoPedido());
        detallePedidoDeliveryGetRequest.setDireccion(delivery.get().getDireccion());
        detallePedidoDeliveryGetRequest.setNumeroContacto(delivery.get().getNumeroContacto());
        detallePedidoDeliveryGetRequest.setEstadoPedido(ventaExiste ? "PAGADO" : "PENDIENTE");

        for (DetallePedido value : detallePedido) {
            if (numPedidos > contador) {
                    if (value.getPedido().getId() == pedido.get().getId()) {
                    DetallePedidoProductoDto detallePedidoProductoDto = new DetallePedidoProductoDto();
                    detallePedidoProductoDto.setDetallePedidoId(pedido.get().getId());
                    detallePedidoProductoDto.setProductoId(value.getProducto().getId());
                    detallePedidoProductoDto.setTipoProducto(value.getProducto().getTipoProducto());
                    detallePedidoProductoDto.setNombreProducto(value.getProducto().getNombre());
                    detallePedidoProductoDto.setDescripcionProducto(value.getProducto().getDescripcion());
                    detallePedidoProductoDto.setPrecioProducto(value.getProducto().getPrecio());
                    detallePedidoProductoDto.setImagenProducto(value.getProducto().getImagen());
                    detallePedidoProductoDto.setDescripcion(value.getProducto().getDescripcion());
                    detallePedidoProductoDto.setCantidad(value.getCantidad());

                    listaPedidos.add(detallePedidoProductoDto);

                    contador ++;
                }
            } else {
                break;
            }
        }

        detallePedidoDeliveryGetRequest.setProductos(listaPedidos);

        return detallePedidoDeliveryGetRequest;
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
            request.getListaMesas().stream().map(detalleMesaDto -> {
                DetalleMesa detalleMesa = new DetalleMesa();
                Mesa mesa = mesaRepository.findById(detalleMesaDto.getIdMesa()).orElseThrow();
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

    public DetallePedido saveDetallePedido(DetallePedido request) {
        request.setEstado(true);
        return detallePedidoRepository.save(request);
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
