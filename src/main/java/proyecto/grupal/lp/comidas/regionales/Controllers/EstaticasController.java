package proyecto.grupal.lp.comidas.regionales.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Estaticas;
import proyecto.grupal.lp.comidas.regionales.Services.IEstaticasServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/estaticas")
public class EstaticasController {

    @Autowired
    private IEstaticasServices services;

    @GetMapping
    public List<Estaticas> getEstaticas() {
        return services.getEstaticas();
    }
    @GetMapping("/{id}")
    public Optional<Estaticas> getEstaticasById(@PathVariable Long id) {
        return services.getEstaticasById(id);
    }

    @PostMapping
    public Estaticas createEstatica(@RequestBody Estaticas estaticas) {
        services.postEstaticas(estaticas);
        return estaticas;
    }
    @PutMapping("/{id}")
    public Estaticas putEstaticas(@PathVariable Long id, @RequestBody Estaticas estaticas) {
        return services.putEstaticas(estaticas,id);
    }

    @DeleteMapping("/{id}")
    public String deleteEstaticas(@PathVariable Long id) {
        services.deleteEstaticas(id);
        return "Campo con el id: " +id+ " Eliminado correctamente";
    }
}
