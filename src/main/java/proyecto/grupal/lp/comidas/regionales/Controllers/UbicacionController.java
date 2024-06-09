package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Ubicacion;
import proyecto.grupal.lp.comidas.regionales.Services.IUbicacionService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/ubicacion")
public class UbicacionController {
    @Autowired
    private IUbicacionService iUbicacionService;
    @GetMapping
    public List<Ubicacion> getUbicacion() {
        return iUbicacionService.getUbicacion();
    }
    @GetMapping("/{id}")
    public Optional<Ubicacion> getUbicacion(@PathVariable Long id) {
        return iUbicacionService.ObtenerUbicacion(id);
    }

    @PostMapping
    public Ubicacion addUbicacion(@RequestBody Ubicacion ubicacion) {
        iUbicacionService.GuardarUbicacion(ubicacion);
        return ubicacion;
    }

    @PutMapping("/{id}")
    public Ubicacion updateUbicacion(@RequestBody Ubicacion ubicacion,@PathVariable Long id) {
        return iUbicacionService.ActualizarUbicacion(ubicacion, id);
    }

    @DeleteMapping("/{id}")
    public String deleteUbicacion(@PathVariable Long id) {
        iUbicacionService.EliminarUbicacion(id);
        return "Ubicacion "+id+" eliminado";
    }
}
