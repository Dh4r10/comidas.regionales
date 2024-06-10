package proyecto.grupal.lp.comidas.regionales.Services.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Cliente;
import proyecto.grupal.lp.comidas.regionales.Entities.DetalleMesa;
import proyecto.grupal.lp.comidas.regionales.Entities.Pedido;
import proyecto.grupal.lp.comidas.regionales.Entities.Venta;
import proyecto.grupal.lp.comidas.regionales.Repositories.*;
import proyecto.grupal.lp.comidas.regionales.Services.IVentaService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private DetalleMesaRepository detalleMesaRepository;
    @Autowired
    private MesaRepository mesaRepository;



    @Override
    public Venta registrarVenta(Venta venta, Long clienteID,Long pedidoID, Long aperturaID) {

        Cliente cliente= clienteRepository.findById(clienteID).orElseThrow();
        Pedido pedido=pedidoRepository.findById(pedidoID).orElseThrow();

        if(pedido.getTipoPedido().equals("SALON")){
            List<DetalleMesa> detalleMesas=detalleMesaRepository.findAllByPedido(pedido);
            Set<Long> idsMesas=detalleMesas.stream()
                    .map(dm-> dm.getMesa().getId()).collect(Collectors.toSet());
            mesaRepository.updateMesaOcupada(idsMesas);
        }

        Venta ventaSv =new Venta();
        ventaSv.setCliente(cliente);
        ventaSv.setPedido(pedido);
        ventaSv.setDescripcion(venta.getDescripcion());
        ventaSv.setCodigoRecibo(venta.getCodigoRecibo());
        ventaSv.setEstado(true);
        ventaSv.setFechaEmision(LocalDate.now());
        ventaSv.setFechaVencimiento(LocalDate.now());
        ventaSv.setMetodoPago(venta.getMetodoPago());
        ventaSv.setTipoPago(venta.getTipoPago());
        ventaSv.setCancelado(venta.getCancelado());
        ventaSv.setTipoComprobante(venta.getTipoComprobante());

        return ventaRepository.save(ventaSv);
    }

    @Override
    public List<Venta> verTodasVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public List<Venta> verVentasPorCliente(Long clienteID) {
        Cliente cliente= clienteRepository.findById(clienteID).orElseThrow();
        return ventaRepository.findAllByCliente(cliente);
    }

    @Override
    public Venta obtenerVentaPorId(Long id) {
        return ventaRepository.findById(id).orElseThrow();
    }

    @Override
    public void anularVenta(Long id) {
        ventaRepository.deleteById(id);
    }
}
