package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Insumo;
import proyecto.grupal.lp.comidas.regionales.Services.IInsumoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/insumo")
public class InsumoController {
    @Autowired
    private IInsumoService iInsumoService;
    @GetMapping
    public List<Insumo> getInsumo() {
        return iInsumoService.getInsumo();
    }
    @GetMapping("/{id}")
    public Optional<Insumo> getInsumo(@PathVariable Long id) {

        return iInsumoService.ObtenerInsumo(id);
    }

    @PostMapping
    public Insumo addProveedor(@RequestBody Insumo insumo) {
        iInsumoService.GuardarInsumo(insumo);
        return insumo;
    }

    @PutMapping("/{id}")
    public Insumo updateInsumo(@RequestBody Insumo insumo,@PathVariable Long id) {
        return iInsumoService.ActualizarInsumo(insumo, id);
    }

    @DeleteMapping("/{id}")
    public String deleteInsumo(@PathVariable Long id) {
        iInsumoService.EliminarInsumo(id);
        return "Insumo "+id+" eliminado";
    }
}
