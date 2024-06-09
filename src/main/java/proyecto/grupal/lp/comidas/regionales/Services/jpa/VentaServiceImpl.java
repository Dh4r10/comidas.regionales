package proyecto.grupal.lp.comidas.regionales.Services.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Cliente;
import proyecto.grupal.lp.comidas.regionales.Entities.Venta;
import proyecto.grupal.lp.comidas.regionales.Repositories.ClienteRepository;
import proyecto.grupal.lp.comidas.regionales.Repositories.VentaRepository;
import proyecto.grupal.lp.comidas.regionales.Services.VentaService;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private VentaRepository ventaRepository;
    @Override
    public Venta registrarVenta(Venta venta, Long clienteID) {

        Cliente cliente= clienteRepository.findById(clienteID).orElseThrow();
        Venta ventaSv =new Venta();
        ventaSv.setCliente(cliente);
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
