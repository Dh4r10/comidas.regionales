package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.DetalleCompra;
import proyecto.grupal.lp.comidas.regionales.Services.IDetalleCompraService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/detalleCompra")
public class DetalleCompraController {
    @Autowired
    private IDetalleCompraService iDetalleCompraService;
    @GetMapping
    public List<DetalleCompra> getDetalleCompra() {
        return iDetalleCompraService.getDetalleCompra();
    }
    @GetMapping("/{id}")
    public Optional<DetalleCompra> getDetalleCompra(@PathVariable Long id) {
        return iDetalleCompraService.ObtenerDetalleCompra(id);
    }

    @PostMapping
    public DetalleCompra addDetalleCompra(@RequestBody DetalleCompra detalleCompra) {
        iDetalleCompraService.GuardarDetalleCompra(detalleCompra);
        return detalleCompra;
    }

    @PutMapping("/{id}")
    public DetalleCompra updateDetalleCompra(@RequestBody DetalleCompra detalleCompra,@PathVariable Long id) {
        return iDetalleCompraService.ActualizarDetalleCompra(detalleCompra, id);
    }

    @DeleteMapping("/{id}")
    public String deleteDetalleCompra(@PathVariable Long id) {
        iDetalleCompraService.EliminarDetalleCompra(id);
        return "DetalleCompra "+id+" eliminado";
    }
}
