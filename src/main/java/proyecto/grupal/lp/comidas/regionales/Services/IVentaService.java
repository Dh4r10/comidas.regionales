package proyecto.grupal.lp.comidas.regionales.Services;



import proyecto.grupal.lp.comidas.regionales.Entities.Venta;

import java.util.List;

public interface IVentaService {


    Venta registrarVenta(Venta venta, Long clienteID,Long pedidoID);
    List<Venta> verTodasVentas();
    List<Venta> verVentasPorCliente(Long clienteID);

    Venta obtenerVentaPorId(Long id);


    void anularVenta(Long id);


}
