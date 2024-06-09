package proyecto.grupal.lp.comidas.regionales.Services;



import proyecto.grupal.lp.comidas.regionales.Entities.Venta;

import java.util.List;

public interface VentaService {


    Venta registrarVenta(Venta venta, Long clienteID);
    List<Venta> verTodasVentas();
    List<Venta> verVentasPorCliente(Long clienteID);

    Venta obtenerVentaPorId(Long id);


    void anularVenta(Long id);


}
