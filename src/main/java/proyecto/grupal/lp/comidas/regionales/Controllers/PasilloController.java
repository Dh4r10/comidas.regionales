package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Pasillo;
import proyecto.grupal.lp.comidas.regionales.Services.IPasilloService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/pasillo")
public class PasilloController {
    @Autowired
    private IPasilloService iPasilloService;
    @GetMapping
    public List<Pasillo> getPasillo() {
        return iPasilloService.getPasillo();
    }
    @GetMapping("/{id}")
    public Optional<Pasillo> getPasillo(@PathVariable Long id) {
        return iPasilloService.ObtenerPasillo(id);
    }

    @PostMapping
    public Pasillo addProveedor(@RequestBody Pasillo pasillo) {
        iPasilloService.GuardarPasillo(pasillo);
        return pasillo;
    }

    @PutMapping("/{id}")
    public Pasillo updatePasillo(@RequestBody Pasillo pasillo,@PathVariable Long id) {
        return iPasilloService.ActualizarPasillo(pasillo, id);
    }

    @DeleteMapping("/{id}")
    public String deletePasillo(@PathVariable Long id) {
        iPasilloService.EliminarPasillo(id);
        return "Pasillo "+id+" eliminado";
    }
}
