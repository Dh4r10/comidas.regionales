package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.MovimientoInsumo;
import proyecto.grupal.lp.comidas.regionales.Services.IMovimientoInsumoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/movimientoInsumo")
public class MovimientoInsumoController {
    @Autowired
    private IMovimientoInsumoService iMovimientoInsumoService;
    @GetMapping
    public List<MovimientoInsumo> getMovimientoInsumo() {
        return iMovimientoInsumoService.getMovimientoInsumo();
    }
    @GetMapping("/{id}")
    public Optional<MovimientoInsumo> getMovimientoInsumo(@PathVariable Long id) {
        return iMovimientoInsumoService.ObtenerMovimientoInsumo(id);
    }

    @PostMapping
    public MovimientoInsumo addProveedor(@RequestBody MovimientoInsumo movimientoInsumo) {
        iMovimientoInsumoService.GuardarMovimientoInsumo(movimientoInsumo);
        return movimientoInsumo;
    }

    @PutMapping("/{id}")
    public MovimientoInsumo updateMovimientoInsumo(@RequestBody MovimientoInsumo movimientoInsumo,@PathVariable Long id) {
        return iMovimientoInsumoService.ActualizarMovimientoInsumo(movimientoInsumo, id);
    }

    @DeleteMapping("/{id}")
    public String deleteMovimientoInsumo(@PathVariable Long id) {
        iMovimientoInsumoService.EliminarMovimientoInsumo(id);
        return "MovimientoInsumo "+id+" eliminado";
    }
}
