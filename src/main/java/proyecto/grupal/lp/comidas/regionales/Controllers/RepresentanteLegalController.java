package proyecto.grupal.lp.comidas.regionales.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.RepresentanteLegal;
import proyecto.grupal.lp.comidas.regionales.Services.jpa.RepresentanteLegalService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/representante-legal")
public class RepresentanteLegalController {

    @Autowired
    private RepresentanteLegalService representanteLegalService;
    @GetMapping
    public List<RepresentanteLegal> getRepresentanteLegal() {
        return representanteLegalService.getRepresentanteLegal();
    }
    @GetMapping("/{id}")
    public Optional<RepresentanteLegal> getRepresentanteLegalById(@PathVariable Long id) {
        return representanteLegalService.getRepresentanteLegalById(id);
    }
    @PostMapping
    public RepresentanteLegal postRepresentanteLegal(@RequestBody RepresentanteLegal representanteLegal) {
        representanteLegalService.postRepresentanteLegal(representanteLegal);
        return representanteLegal;
    }

    @PutMapping("/{id}")
    public RepresentanteLegal putRepresentanteLegal(@PathVariable Long id, @RequestBody RepresentanteLegal representanteLegal) {
        return representanteLegalService.putRepresentanteLegal(representanteLegal, id);
    }

    @DeleteMapping("/{id}")
    public String deleteRepresentanteLegal(@PathVariable Long id) {
        representanteLegalService.deleteRepresentanteLegal(id);
        return "Representante Legal" + id + " eliminado correctamente";
    }
}
