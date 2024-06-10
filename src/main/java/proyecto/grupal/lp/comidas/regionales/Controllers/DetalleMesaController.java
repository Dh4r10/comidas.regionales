package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.DetalleMesa;
import proyecto.grupal.lp.comidas.regionales.Services.IDetalleMesaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/detalle-pedido-mesa")
public class DetalleMesaController {

    @Autowired
    private IDetalleMesaService detallePedidoMesaService;

     @GetMapping
    public List<DetalleMesa> getAllDetallePedidos() {
        return detallePedidoMesaService.getAllDetallePedidoMesas();
    }

    @GetMapping("/{id}")
    public Optional<DetalleMesa> getDetallePedidoById(@PathVariable Long id) {
        return detallePedidoMesaService.getDetallePedidoMesaById(id);
    }

    @PostMapping
    public DetalleMesa postDetallePedido(@RequestBody DetalleMesa request) {
        detallePedidoMesaService.postDetallePedidoMesa(request);
        return request;
    }

    @PutMapping("/{id}")
    public DetalleMesa putDetallePedido(@PathVariable Long id, @RequestBody DetalleMesa request) {
        return detallePedidoMesaService.putDetallePedidoMesa(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteDetallePedido(@PathVariable Long id) {
        detallePedidoMesaService.deleteDetallePedidoMesa(id);
        return "DetallePedido con id=" + id + " eliminado correctamente";
    }

}
