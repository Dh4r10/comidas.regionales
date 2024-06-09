package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Parametros;
import proyecto.grupal.lp.comidas.regionales.Services.IParametroServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/parametros")
public class ParametrosController {

    @Autowired
    private IParametroServices parametroServices;

    @GetMapping
    public List<Parametros> getParametros() {
    return parametroServices.getParametros();
    }
    @GetMapping("/{id}")
    public Optional<Parametros> getParametrosById(@PathVariable Long id) {
        return parametroServices.getParametrosById(id);
    }
    @PostMapping
    public Parametros postParametros(@RequestBody Parametros parametros) {
        parametroServices.postParametros(parametros);
        return parametros;
    }

    @PutMapping("/{id}")
    public Parametros putParametros(@PathVariable Long id, @RequestBody Parametros parametros) {
        return parametroServices.putParametros(parametros,id);
    }
    @DeleteMapping("/{id}")
    public String deleteParametros(@PathVariable Long id) {
        parametroServices.deleteParametros(id);
        return "Campos "+id+ " eliminados com correctamente!";
    }
}
