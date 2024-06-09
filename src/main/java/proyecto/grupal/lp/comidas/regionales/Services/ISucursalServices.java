package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Sucursal;

import java.util.List;
import java.util.Optional;

public interface ISucursalServices {

    List<Sucursal> getSucursales();
    Optional<Sucursal> getSucursalesId(Long id);
    void postSucursal(Sucursal sucursal);
    Sucursal putSucursal(Sucursal sucursal,Long id);
    void deleteSucursales(Long id);
}
