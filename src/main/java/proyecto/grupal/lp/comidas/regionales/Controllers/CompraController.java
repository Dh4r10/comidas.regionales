package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Compra;
import proyecto.grupal.lp.comidas.regionales.Services.ICompraService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/compra")
public class CompraController {
    @Autowired
    private ICompraService iCompraService;
    @GetMapping
    public List<Compra> getCompra() {
        return iCompraService.getCompra();
    }
    @GetMapping("/{id}")
    public Optional<Compra> getCompra(@PathVariable Long id) {
        return iCompraService.ObtenerCompra(id);
    }

    @PostMapping
    public Compra addCompra(@RequestBody Compra compra) {
        iCompraService.GuardarCompra(compra);
        return compra;
    }

    @PutMapping("/{id}")
    public Compra updateCompra(@RequestBody Compra compra,@PathVariable Long id) {
        return iCompraService.ActualizarCompra(compra, id);
    }

    @DeleteMapping("/{id}")
    public String deleteCompra(@PathVariable Long id) {
        iCompraService.EliminarCompra(id);
        return "Compra "+id+" eliminado";
    }
}
