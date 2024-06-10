package proyecto.grupal.lp.comidas.regionales.Controllers;
import proyecto.grupal.lp.comidas.regionales.Entities.PermisoXEstablecimiento;
import proyecto.grupal.lp.comidas.regionales.Services.IPermisoXEstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/permisoXEstablecimiento")
public class PermisoXEstablecimientoController {

    @Autowired
    private IPermisoXEstablecimientoService permisoXEstablecimientoService;

    @GetMapping
    public List<PermisoXEstablecimiento> getAllPermisoXEstablecimiento() {
        return permisoXEstablecimientoService.getAllPermisoXEstablecimiento();
    }

    @GetMapping("/{id}")
    public Optional<PermisoXEstablecimiento> getPermisoXEstablecimientoById(@PathVariable Long id) {
        return permisoXEstablecimientoService.getPermisoXEstablecimientoById(id);
    }

    @PostMapping
    public PermisoXEstablecimiento postPermisoXEstablecimiento(@RequestBody PermisoXEstablecimiento permisoXEstablecimiento) {
        permisoXEstablecimientoService.postPermisoXEstablecimiento(permisoXEstablecimiento);
        return permisoXEstablecimiento;
    }

    @PutMapping("/{id}")
    public PermisoXEstablecimiento putPermisoXEstablecimiento(@PathVariable Long id, @RequestBody PermisoXEstablecimiento permisoXEstablecimiento) {
        return permisoXEstablecimientoService.putPermisoXEstablecimiento(permisoXEstablecimiento, id);
    }

    @DeleteMapping("/{id}")
    public String deletePermisoXEstablecimiento(@PathVariable Long id) {
        permisoXEstablecimientoService.deletePermisoXEstablecimiento(id);
        return "PermisoXEstablecimiento con id=" + id + " eliminado correctamente";
    }
}

