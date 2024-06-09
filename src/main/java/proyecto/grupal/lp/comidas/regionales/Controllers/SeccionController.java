package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Seccion;
import proyecto.grupal.lp.comidas.regionales.Services.ISeccionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/seccion")
public class SeccionController {

    @Autowired
    private ISeccionService seccionService;

    @GetMapping
    public List<Seccion> getAllSecciones() {
        return seccionService.getAllSecciones();
    }

    @GetMapping("/{id}")
    public Optional<Seccion> getSeccionById(@PathVariable Long id) {
        return seccionService.getSeccionById(id);
    }

    @PostMapping
    public Seccion postSeccion(@RequestBody Seccion request) {
        seccionService.postSeccion(request);
        return request;
    }

    @PutMapping("/{id}")
    public Seccion putSeccion(@RequestBody Seccion request, @PathVariable Long id) {
        return seccionService.putSeccion(request, id);
    }

    @PatchMapping("/{id}")
    public Seccion patchSeccion(@RequestBody Seccion request, @PathVariable Long id) {
        return seccionService.patchSeccion(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteSeccion(@PathVariable Long id) {
        seccionService.deleteSeccion(id);
        return "Seccion con id=" + id + " eliminado correctamente";
    }

}
