package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Pedido;
import proyecto.grupal.lp.comidas.regionales.Services.IPedidoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pedido")
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> getPedidoById(@PathVariable Long id) {
        return pedidoService.getPedidoById(id);
    }

    @PostMapping
    public Pedido postPedido(@RequestBody Pedido request) {
        pedidoService.postPedido(request);
        return request;
    }

    @PutMapping("/{id}")
    public Pedido putPedido(@PathVariable Long id, @RequestBody Pedido request) {
        return pedidoService.putPedido(request, id);
    }

    @DeleteMapping("/{id}")
    public String deletePedido(@PathVariable Long id) {
        pedidoService.deletePedido(id);
        return "Pedido con id=" + id + " eliminado correctamente";
    }

}
