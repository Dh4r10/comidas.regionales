package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto.grupal.lp.comidas.regionales.Dto.DetalleMesaDto;
import proyecto.grupal.lp.comidas.regionales.Dto.DetallePedidoDto;
import proyecto.grupal.lp.comidas.regionales.Dto.PedidoDtoGetRequest;
import proyecto.grupal.lp.comidas.regionales.Entities.*;
import proyecto.grupal.lp.comidas.regionales.Dto.PedidoDtoPostRequest;
import proyecto.grupal.lp.comidas.regionales.Repositories.*;
import proyecto.grupal.lp.comidas.regionales.Services.IPedidoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        return pedidoRepository.findAll();
    }

    public PedidoDtoGetRequest getPedidoById(Long id) {

        Optional<Pedido> pedido = pedidoRepository.findById(id);

        List<DetallePedido> detallePedido = detallePedidoRepository.findAll();
        List<DetallePedidoDto> listaPedidos = new ArrayList<>();

        List<DetalleMesa> detalleMesa = detalleMesaRepository.findAll();
        List<DetalleMesaDto> listaMesas = new ArrayList<>();

        boolean ventaExiste = ventaRepository.existsByPedidoId(id);
        long numPedidos = detallePedidoRepository.countIdByDetallePedido(id);
        long numMesas = detalleMesaRepository.countIdByDetalleMesa(id);
        long contadorPedido = 0;
        long contadorMesas = 0;

        PedidoDtoGetRequest pedidoBoleta = new PedidoDtoGetRequest();
        pedidoBoleta.setIdPedido(id);
        pedidoBoleta.setTipoPedido(pedido.get().getTipoPedido());
        pedidoBoleta.setFecha(pedido.get().getFecha());
        pedidoBoleta.setEstadoPedido(ventaExiste ? "ENTREGADO" : "PENDIENTE");

        for (DetallePedido value : detallePedido) {
            if (numPedidos > contadorPedido) {
                    if (value.getPedido().getId() == id) {
                    DetallePedidoDto detallePedidoDto = new DetallePedidoDto();
                    detallePedidoDto.setProductoId(value.getProducto().getId());
                    detallePedidoDto.setNombreProducto(value.getProducto().getNombre());
                    detallePedidoDto.setDescripcionProducto(value.getProducto().getDescripcion());
                    detallePedidoDto.setPrecioProducto(value.getProducto().getPrecio());
                    detallePedidoDto.setImagenProducto(value.getProducto().getImagen());
                    detallePedidoDto.setDescripcion(value.getProducto().getDescripcion());
                    detallePedidoDto.setCantidad(value.getCantidad());

                    listaPedidos.add(detallePedidoDto);

                    contadorPedido++;
                }
            } else {
                break;
            }
        }

        pedidoBoleta.setListaPedidos(listaPedidos);

        for (DetalleMesa value : detalleMesa) {
            if (numMesas > contadorMesas) {
                    if (value.getPedido().getId() == id) {
                    DetalleMesaDto detalleMesaDto = new DetalleMesaDto();
                    detalleMesaDto.setMesaId(value.getMesa().getId());
                    detalleMesaDto.setTipoMesa(value.getMesa().getTipoMesa());
                    detalleMesaDto.setNumero(value.getMesa().getNumero());
                    detalleMesaDto.setCapacidad(value.getMesa().getCapacidad());
                    detalleMesaDto.setReservado(value.getMesa().getReservado());
                    detalleMesaDto.setOcupado(value.getMesa().getOcupado());

                    listaMesas.add(detalleMesaDto);

                    contadorMesas++;
                }
            } else {
                break;
            }
        }

        pedidoBoleta.setListaMesas(listaMesas);

        return pedidoBoleta;
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
            request.getListaMesa().stream().map(detalleMesaDto -> {
                DetalleMesa detalleMesa = new DetalleMesa();
                Mesa mesa = mesaRepository.findById(detalleMesaDto.getMesaId()).orElseThrow();
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
