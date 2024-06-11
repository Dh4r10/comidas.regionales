package proyecto.grupal.lp.comidas.regionales.Controllers;

import proyecto.grupal.lp.comidas.regionales.Entities.Modulo;
import proyecto.grupal.lp.comidas.regionales.Services.IModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/modulo")
public class ModuloController {

    @Autowired
    private IModuloService moduloService;

    @GetMapping
    public List<Modulo> getAllModulo() {
        return moduloService.getAllModulo();
    }

    @GetMapping("/{id}")
    public Optional<Modulo> getModuloById(@PathVariable Long id) {
        return moduloService.getModuloById(id);
    }

    @PostMapping
    public Modulo postModulo(@RequestBody Modulo modulo) {
        moduloService.postModulo(modulo);
        return modulo;
    }

    @PutMapping("/{id}")
    public Modulo putModulo(@PathVariable Long id, @RequestBody Modulo modulo) {
        return moduloService.putModulo(modulo, id);
    }


    @DeleteMapping("/{id}")
    public String deleteModulo(@PathVariable Long id) {
        moduloService.deleteModulo(id);
        return "Modulo con id=" + id + " eliminado correctamente";
    }

}
