package proyecto.grupal.lp.comidas.regionales.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto.grupal.lp.comidas.regionales.Services.IDetalleVentaService;


@RestController
@RequestMapping("/api/v1/detalles-ventas")
public class DetallesVentasController {


    @Autowired
    private IDetalleVentaService detalleVentaService;

    @GetMapping("/venta/{id}")
    public ResponseEntity<?> verDetallesVentas(@PathVariable Long id){

        return ResponseEntity.ok(detalleVentaService.verDetalleVentas(id));
    }


}
