package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Caja;
import proyecto.grupal.lp.comidas.regionales.Services.ICajaServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/caja")
public class CajaController {

    @Autowired
    private ICajaServices cajaServices;

    @GetMapping
    public List<Caja> getCaja(){
        return cajaServices.getCaja();
    }

    @GetMapping("/{id}")
    public Optional<Caja> getCajaById(@PathVariable Long id){
        return cajaServices.getCajaById(id);
    }

    @PostMapping
    public Caja putCaja(@RequestBody Caja caja){
        cajaServices.postCaja(caja);
        return caja;
    }

    @PutMapping("/{id}")
    public Caja putCaja(@RequestBody Caja caja, @PathVariable Long id){
        return cajaServices.putCaja(id,caja);
    }
    @DeleteMapping("/{id}")
    public String deleteCaja(@PathVariable Long id){
        cajaServices.deleteCaja(id);
        return "Caja "+id+" deletado com sucesso!";
    }
}
