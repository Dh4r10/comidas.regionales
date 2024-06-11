package proyecto.grupal.lp.comidas.regionales.Controllers;
import proyecto.grupal.lp.comidas.regionales.Entities.Permiso;
import proyecto.grupal.lp.comidas.regionales.Services.IPermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/permiso")
public class PermisoController {

    @Autowired
    private IPermisoService permisoService;

    @GetMapping
    public List<Permiso> getAllPermiso() {
        return permisoService.getAllPermiso();
    }

    @GetMapping("/{id}")
    public Optional<Permiso> getPermisoById(@PathVariable Long id) {
        return permisoService.getPermisoById(id);
    }

    @PostMapping
    public Permiso postPermiso(@RequestBody Permiso permiso) {
        permisoService.postPermiso(permiso);
        return permiso;
    }

    @PutMapping("/{id}")
    public Permiso putPermiso(@PathVariable Long id, @RequestBody Permiso permiso) {
        return permisoService.putPermiso(permiso, id);
    }

    @DeleteMapping("/{id}")
    public String deletePermiso(@PathVariable Long id) {
        permisoService.deletePermiso(id);
        return "Permiso con id=" + id + " eliminado correctamente";
    }
}
