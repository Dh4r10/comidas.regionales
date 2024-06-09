package proyecto.grupal.lp.comidas.regionales.Services.jpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Proveedor;
import proyecto.grupal.lp.comidas.regionales.Repositories.ProveedorRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IProveedorService;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService implements IProveedorService {
    //Esto esna funcion get
    @Autowired
    private ProveedorRepository proveedorRepository;
    public List<Proveedor> getProveedor(){

        return proveedorRepository.findAll();
    }

    public Optional<Proveedor> ObtenerProveedor(Long id) {
        return proveedorRepository.findById(id);
    }

    public void GuardarProveedor(Proveedor proveedor) {
        if (proveedor.getEstado()==null){
            proveedor.setEstado(true);
        }
        proveedorRepository.save(proveedor);
    }
    public Proveedor ActualizarProveedor(Proveedor proveedor, Long id) {
        Proveedor p = proveedorRepository.findById(id).get();
        p.setRuc(proveedor.getRuc());
        p.setTipoRuc(proveedor.getTipoRuc());
        p.setRazonSocial(proveedor.getRazonSocial());
        p.setTelefono(proveedor.getTelefono());
        p.setCorreo(proveedor.getCorreo());

        if(proveedor.getEstado()==null){
            p.setEstado(p.getEstado());
        }
        else{
            p.setEstado(proveedor.getEstado());
        }
        return proveedorRepository.save(p);
    }
public void EliminarProveedor(Long id) {
        proveedorRepository.deleteById(id);
}
}
