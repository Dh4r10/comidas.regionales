package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.DetalleVenta;
import proyecto.grupal.lp.comidas.regionales.Entities.Venta;
import proyecto.grupal.lp.comidas.regionales.Repositories.DetalleVentaRepository;
import proyecto.grupal.lp.comidas.regionales.Repositories.VentaRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IDetalleVentaService;

import java.util.List;

@Service
public class DetalleVentaImpl implements IDetalleVentaService {

    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Override
    public List<DetalleVenta> verDetalleVentas(Long ventaID) {
        Venta venta=ventaRepository.findById(ventaID).orElseThrow();
        List<DetalleVenta> detalleVentas=detalleVentaRepository.findAllByVenta(venta);
        return detalleVentas;
    }


}
