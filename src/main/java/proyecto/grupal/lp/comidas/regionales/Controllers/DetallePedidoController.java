package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Dto.DetallePedidoDeliveryGetRequest;
import proyecto.grupal.lp.comidas.regionales.Dto.DetallePedidoPostRequest;
import proyecto.grupal.lp.comidas.regionales.Dto.DetallePedidoSalonGetRequest;
import proyecto.grupal.lp.comidas.regionales.Entities.DetallePedido;
import proyecto.grupal.lp.comidas.regionales.Entities.Pedido;
import proyecto.grupal.lp.comidas.regionales.Services.IDetallePedidoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/detalle-pedido")
public class DetallePedidoController {

    @Autowired
    private IDetallePedidoService detallePedidoService;

    @GetMapping
    public List<DetallePedido> getAllDetallePedidos() {
        return detallePedidoService.getAllDetallePedidos();
    }

    @GetMapping("/{id}")
    public Optional<DetallePedido> getDetallePedidoById(@PathVariable Long id) {
        return detallePedidoService.getDetallePedidoById(id);
    }

    @GetMapping("/delivery/{id}")
    public DetallePedidoDeliveryGetRequest getDetallePedidoDeliveryById(@PathVariable Long id){
        return detallePedidoService.getDetallePedidoDeliveryById(id);
    }

    @GetMapping("/salon/{id}")
    public DetallePedidoSalonGetRequest getDetallePedidoSalonById(@PathVariable Long id){
        return detallePedidoService.getDetallePedidoSalonById(id);
    }

    @PostMapping
    public Pedido postDetallePedido(@RequestBody DetallePedidoPostRequest request) {
        return detallePedidoService.postDetallePedido(request);
    }

    @PutMapping("/{id}")
    public DetallePedido putDetallePedido(@PathVariable Long id, @RequestBody DetallePedido request) {
        return detallePedidoService.putDetallePedido(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteDetallePedido(@PathVariable Long id) {
        detallePedidoService.deleteDetallePedido(id);
        return "DetallePedido con id=" + id + " eliminado correctamente";
    }

}
