package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.DetalleReserva;
import proyecto.grupal.lp.comidas.regionales.Services.IDetalleReservaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/detalle-reserva")
public class DetalleReservaController {

    @Autowired
    private IDetalleReservaService detalleReservaService;

    @GetMapping
    public List<DetalleReserva> getAllDetalleReservas() {
        return detalleReservaService.getAllDetalleReservas();
    }

    @GetMapping("/{id}")
    public Optional<DetalleReserva> getDetalleReservaById(@PathVariable Long id) {
        return detalleReservaService.getDetalleReservaById(id);
    }

    @PostMapping
    public DetalleReserva postDetalleReserva(@RequestBody DetalleReserva request) {
        detalleReservaService.postDetalleReserva(request);
        return request;
    }

    @PutMapping("/{id}")
    public DetalleReserva putDetalleReserva(@PathVariable Long id, @RequestBody DetalleReserva request) {
        return detalleReservaService.putDetalleReserva(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteDetalleReserva(@PathVariable Long id) {
        detalleReservaService.deleteDetalleReserva(id);
        return "Reserva con id=" + id + " eliminado correctamente";
    }

}
