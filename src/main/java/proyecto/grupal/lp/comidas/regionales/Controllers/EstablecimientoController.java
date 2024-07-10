package proyecto.grupal.lp.comidas.regionales.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Establecimiento;
import proyecto.grupal.lp.comidas.regionales.Services.IEstableciminetoServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/establecimiento")
public class EstablecimientoController {

    @Autowired
    private IEstableciminetoServices establecimientoServices;

    @GetMapping
    public List<Establecimiento> obtenerEstablecimiento() {
        return establecimientoServices.getEstablecimiento();
    }

    @GetMapping("/condicionado/{idE}")
    //El PathVariable se utiliza para extraer valores de la URL de la api y así filtrar
    public Optional<Establecimiento> obtenerEstablecimientoCondicionado(@PathVariable Long idE) {
      return establecimientoServices.getEstablecimientoCondicionado(idE);
    }

        //Para filtrar por Id
    @GetMapping("/{id}")
    //El PathVariable se utiliza para extraer valores de la URL de la api y así filtrar
    public Optional<Establecimiento> obtenerEstablecimientoId(@PathVariable Long id) {
      return  establecimientoServices.getEstablecimientoId(id);
    }

    @PostMapping
    public Establecimiento postEstablecimiento(@RequestBody Establecimiento establecimiento) {
        establecimientoServices.postEstablecimiento(establecimiento);
        return establecimiento;
    }
    @PutMapping("/{id}")
    public Establecimiento puEstablecimiento(@RequestBody Establecimiento est,@PathVariable Long id) {
       return establecimientoServices.putEstablecimiento(est,id);
    }

    @DeleteMapping("/{id}")
    public String deleteEstablecimiento(@PathVariable Long id) {
        establecimientoServices.deleteEstablecimiento(id);
        return "registro" + id  +"correctamente eliminado";
    }
}
