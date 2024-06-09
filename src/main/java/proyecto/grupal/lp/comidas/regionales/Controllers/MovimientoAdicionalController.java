package proyecto.grupal.lp.comidas.regionales.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.MovimientoAdicional;
import proyecto.grupal.lp.comidas.regionales.Services.IMovimientoAdicionalServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/movimiento-adicional")
public class MovimientoAdicionalController {

    @Autowired
    private IMovimientoAdicionalServices movimientoAdicionalServices;
@GetMapping
    public List<MovimientoAdicional> getMovimientoAdicional() {
        return movimientoAdicionalServices.getMovimientoAdicional();
    }
    @GetMapping("/{id}")
    public Optional<MovimientoAdicional> getMovimientoAdicionalById(@PathVariable Long id) {
        return movimientoAdicionalServices.getMovimientoAdicionalById(id);
    }
    @PostMapping
    public MovimientoAdicional postMovimientoAdicional(
           @RequestBody MovimientoAdicional movimientoAdicional) {
        movimientoAdicionalServices.postMovimientoAdicional(movimientoAdicional);
        return movimientoAdicional;
    }
@PutMapping("/{id}")
    public MovimientoAdicional putMovimientoAdicional(@RequestBody MovimientoAdicional movimientoAdicional,@PathVariable Long id) {
        return movimientoAdicionalServices.putMovimientoAdicional(movimientoAdicional, id);
    }
    @DeleteMapping("/{id}")
    public String deleteMovimientoAdicional(@PathVariable Long id) {
        movimientoAdicionalServices.deleteMovimientoAdicional(id);
        return "Movimiento adicional "+id+" removido com sucesso";
    }
}
