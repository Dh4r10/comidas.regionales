package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Responsable;
import proyecto.grupal.lp.comidas.regionales.Services.IResponsableServices;
import proyecto.grupal.lp.comidas.regionales.Services.jpa.ResponsableService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/responsable")
public class ResponsableController {

    @Autowired
    private IResponsableServices responsableServices;

    @GetMapping
    public List<Responsable> obtenerResponsables() {
        return responsableServices.getResponsable();
    }
    @GetMapping("/{id}")
    public Optional<Responsable> obtenerResponsable(@PathVariable Long id) {
        return responsableServices.getResponsableId(id);
    }
    @PostMapping
    public Responsable guardarResponsable(@RequestBody Responsable responsable) {
        responsableServices.postResponsable(responsable);
        return responsable;
    }
    @PutMapping("/{id}")
    public Responsable actualizarResponsable(@RequestBody Responsable responsable,@PathVariable Long id) {
        return responsableServices.putResponsable(responsable, id);
    }
    @DeleteMapping("/{id}")
    public String deleteResponsable(@PathVariable Long id) {
        responsableServices.delteResponsable(id);
        return "Eliminado " + id+" Correctamente";
    }
}
