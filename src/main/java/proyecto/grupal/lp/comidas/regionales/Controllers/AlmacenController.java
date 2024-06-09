package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Almacen;
import proyecto.grupal.lp.comidas.regionales.Services.IAlmacenService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/almacen")
public class AlmacenController {
    @Autowired
    private IAlmacenService iAlmacenService;
    @GetMapping
    public List<Almacen> getAlmacen() {
        return iAlmacenService.getAlmacen();
    }
    @GetMapping("/{id}")
    public Optional<Almacen> getAlmacen(@PathVariable Long id) {
        return iAlmacenService.ObtenerAlmacen(id);
    }

    @PostMapping
    public Almacen addProveedor(@RequestBody Almacen almacen) {
        iAlmacenService.GuardarAlmacen(almacen);
        return almacen;
    }

    @PutMapping("/{id}")
    public Almacen updateAlmacen(@RequestBody Almacen almacen,@PathVariable Long id) {
        return iAlmacenService.ActualizarAlmacen(almacen, id);
    }

    @DeleteMapping("/{id}")
    public String deleteAlmacen(@PathVariable Long id) {
        iAlmacenService.EliminarAlmacen(id);
        return "Almacen "+id+" eliminado";
    }
}
