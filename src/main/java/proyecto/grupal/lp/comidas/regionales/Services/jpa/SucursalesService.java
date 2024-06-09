package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Sucursal;
import proyecto.grupal.lp.comidas.regionales.Repositories.SucursalesRepository;
import proyecto.grupal.lp.comidas.regionales.Services.ISucursalServices;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalesService implements ISucursalServices {
    @Autowired
    private SucursalesRepository sucursalesRepository;

    public List<Sucursal> getSucursales() {
        return sucursalesRepository.findAll();
    }

    public Optional<Sucursal> getSucursalesId(Long id) {
        return sucursalesRepository.findById(id);
    }
    public void postSucursal(Sucursal sucursal) {
        sucursalesRepository.save(sucursal);
    }

    public Sucursal putSucursal(Sucursal sucursal, Long id) {
        Sucursal sucursal1 = sucursalesRepository.findById(id).get();
        sucursal1.setDireccion(sucursal.getDireccion());
        sucursal1.setNombre(sucursal.getNombre());
        sucursal1.setTelefono(sucursal.getTelefono());
        sucursal1.setIdEstablecimiento(sucursal.getIdEstablecimiento());
        sucursal1.setReferencia(sucursal.getReferencia());
        sucursal1.setDepartamento_direccion(sucursal.getDepartamento_direccion());
        sucursal1.setDistrito_direccion(sucursal.getDistrito_direccion());
        sucursal1.setProvincia_direccion(sucursal.getProvincia_direccion());
        sucursalesRepository.save(sucursal1);
        return sucursal1;
    }
    public void deleteSucursales(Long id){
        sucursalesRepository.deleteById(id);
    }
}
