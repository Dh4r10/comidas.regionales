package proyecto.grupal.lp.comidas.regionales.Services;


import proyecto.grupal.lp.comidas.regionales.Entities.Proveedor;

import java.util.List;
import java.util.Optional;

public interface IProveedorService {
    List<Proveedor> getProveedor();
    Optional<Proveedor> ObtenerProveedor(Long id);
    void GuardarProveedor(Proveedor proveedor);
    Proveedor ActualizarProveedor(Proveedor proveedor,Long id);
    void EliminarProveedor(Long id);
}

