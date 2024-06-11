package proyecto.grupal.lp.comidas.regionales.Controllers;
import proyecto.grupal.lp.comidas.regionales.Entities.Pantalla;
import proyecto.grupal.lp.comidas.regionales.Services.IPantallaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pantalla")
public class PantallaController {

    @Autowired
    private IPantallaService pantallaService;

    @GetMapping
    public List<Pantalla> getAllPantalla() {
        return pantallaService.getAllPantalla();
    }

    @GetMapping("/{id}")
    public Optional<Pantalla> getPantallaById(@PathVariable Long id) {
        return pantallaService.getPantallaById(id);
    }

    @PostMapping
    public Pantalla postPantalla(@RequestBody Pantalla pantalla) {
        pantallaService.postPantalla(pantalla);
        return pantalla;
    }

    @PutMapping("/{id}")
    public Pantalla putPantalla(@PathVariable Long id, @RequestBody Pantalla pantalla) {
        return pantallaService.putPantalla(pantalla, id);
    }

    @DeleteMapping("/{id}")
    public String deletePantalla(@PathVariable Long id) {
        pantallaService.deletePantalla(id);
        return "Pantalla con id=" + id + " eliminada correctamente";
    }
}
