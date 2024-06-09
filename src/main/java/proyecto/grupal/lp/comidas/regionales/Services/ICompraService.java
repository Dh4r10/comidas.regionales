package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Compra;

import java.util.List;
import java.util.Optional;

public interface ICompraService {
    List<Compra> getCompra();
    Optional<Compra> ObtenerCompra(Long id);
    void GuardarCompra(Compra compra);
    Compra ActualizarCompra(Compra compra,Long id);
    void EliminarCompra(Long id);
}

