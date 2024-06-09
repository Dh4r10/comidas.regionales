package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Mesa;
import proyecto.grupal.lp.comidas.regionales.Services.IMesaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/mesa")
public class MesaController {

    @Autowired
    private IMesaService mesaService;

    @GetMapping
    public List<Mesa> getAllMesas() {
        return mesaService.getAllMesas();
    }

    @GetMapping("/{id}")
    public Optional<Mesa> getMesaById(@PathVariable Long id) {
        return mesaService.getMesaById(id);
    }

    @PostMapping
    public Mesa postSalon(@RequestBody Mesa request) {
        mesaService.postMesa(request);
        return request;
    }

    @PutMapping("/{id}")
    public Mesa putMesa(@PathVariable Long id, @RequestBody Mesa request) {
        return mesaService.putMesa(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteMesa(@PathVariable Long id) {
        mesaService.deleteMesa(id);
        return "Mesa con id=" + id + " eliminado correctamente";
    }

}
