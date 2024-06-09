package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.DetallePedidoMesa;
import proyecto.grupal.lp.comidas.regionales.Services.IDetallePedidoMesaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/detalle-pedido-mesa")
public class DetallePedidoMesaController {

    @Autowired
    private IDetallePedidoMesaService detallePedidoMesaService;

     @GetMapping
    public List<DetallePedidoMesa> getAllDetallePedidos() {
        return detallePedidoMesaService.getAllDetallePedidoMesas();
    }

    @GetMapping("/{id}")
    public Optional<DetallePedidoMesa> getDetallePedidoById(@PathVariable Long id) {
        return detallePedidoMesaService.getDetallePedidoMesaById(id);
    }

    @PostMapping
    public DetallePedidoMesa postDetallePedido(@RequestBody DetallePedidoMesa request) {
        detallePedidoMesaService.postDetallePedidoMesa(request);
        return request;
    }

    @PutMapping("/{id}")
    public DetallePedidoMesa putDetallePedido(@PathVariable Long id, @RequestBody DetallePedidoMesa request) {
        return detallePedidoMesaService.putDetallePedidoMesa(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteDetallePedido(@PathVariable Long id) {
        detallePedidoMesaService.deleteDetallePedidoMesa(id);
        return "DetallePedido con id=" + id + " eliminado correctamente";
    }

}
