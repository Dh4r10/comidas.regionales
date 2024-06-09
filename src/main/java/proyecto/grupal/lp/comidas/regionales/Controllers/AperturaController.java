package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Apertura;
import proyecto.grupal.lp.comidas.regionales.Services.IAperturaServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/apertura")
public class AperturaController {

    @Autowired
    private IAperturaServices aperturaServices;

    @GetMapping
    public List<Apertura> getAperturas() {
        return aperturaServices.getAperturas();
    }
    @GetMapping("/{id}")
    public Optional<Apertura> getAperturaById(@PathVariable Long id) {
        return aperturaServices.getAperturaById(id);
    }
    @PostMapping
    public Apertura postApertura(@RequestBody Apertura apertura) {
        aperturaServices.postApertura(apertura);
        return apertura;
    }

    @PutMapping("/{id}")
    public Apertura putApertura(@PathVariable Long id, @RequestBody Apertura apertura) {
        return aperturaServices.putApertura(id, apertura);
    }
    @DeleteMapping("/{id}")
    public String deleteApertura(@PathVariable Long id) {
        aperturaServices.deleteApertura(id);
        return "Apertura "+id+" eliminada";
    }
}
