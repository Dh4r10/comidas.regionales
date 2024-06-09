package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Proveedor;
import proyecto.grupal.lp.comidas.regionales.Services.IProveedorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/proveedores")
public class ProveedoreController {
    @Autowired
    private IProveedorService iProveedorService;
    @GetMapping
    public List<Proveedor> getProveedores() {
        return iProveedorService.getProveedor();
    }
    @GetMapping("/{id}")
    public Optional<Proveedor> getProveedore(@PathVariable Long id) {
        return iProveedorService.ObtenerProveedor(id);
    }

    @PostMapping
    public Proveedor addProveedor(@RequestBody Proveedor proveedor) {
        iProveedorService.GuardarProveedor(proveedor);
        return proveedor;
    }

    @PutMapping("/{id}")
    public Proveedor updateProveedor(@RequestBody Proveedor proveedor,@PathVariable Long id) {
        return iProveedorService.ActualizarProveedor(proveedor, id);
    }

    @DeleteMapping("/{id}")
    public String deleteProveedor(@PathVariable Long id) {
        iProveedorService.EliminarProveedor(id);
        return "Proveedor "+id+" eliminado";
    }
}
