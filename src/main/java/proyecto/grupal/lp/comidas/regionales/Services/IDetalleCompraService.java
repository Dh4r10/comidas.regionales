package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.DetalleCompra;

import java.util.List;
import java.util.Optional;

public interface IDetalleCompraService {
    List<DetalleCompra> getDetalleCompra();
    Optional<DetalleCompra> ObtenerDetalleCompra(Long id);
    void GuardarDetalleCompra(DetalleCompra detalleCompra);
    DetalleCompra ActualizarDetalleCompra(DetalleCompra detalleCompra,Long id);
    void EliminarDetalleCompra(Long id);
}
