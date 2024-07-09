package proyecto.grupal.lp.comidas.regionales.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Venta;
import proyecto.grupal.lp.comidas.regionales.Services.IVentaService;

@RestController
@RequestMapping("/api/v1/ventas")
public class VentasController {
    @Autowired
    private IVentaService ventaService;

    @PostMapping("/create/client/{id}/pedido/{pedido_id}/apertura/{apertura_id}")
    public ResponseEntity<?> registrarVenta(@RequestBody Venta venta,
                                            @PathVariable Long id,
                                            @PathVariable("pedido_id") Long pedidoID,
                                            @PathVariable("aperturaID") Long aperturaID
                                            ){
        return new ResponseEntity<>(ventaService.registrarVenta(venta,id,pedidoID,aperturaID), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> verVentas(){
        return ResponseEntity.ok(ventaService.verTodasVentas());
    }

    @GetMapping("/all/cliente/{id}")
    public ResponseEntity<?> verVentasPorCLiente(@PathVariable Long id){
        return ResponseEntity.ok(ventaService.verVentasPorCliente(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerVenta(@PathVariable Long id){
        return ResponseEntity.ok(ventaService.obtenerVentaPorId(id));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarVenta(@PathVariable Long id){
        ventaService.anularVenta(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all/sucursal/{id}")
    public ResponseEntity<?> verVentasPorSucursal(@PathVariable Long id){
        return ResponseEntity.ok(ventaService.listarVentarPorSucursal(id));
    }




}
