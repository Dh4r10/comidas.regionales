package proyecto.grupal.lp.comidas.regionales.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Sucursal;
import proyecto.grupal.lp.comidas.regionales.Services.ISucursalServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/sucursales")
public class SucursalesController {

    @Autowired private ISucursalServices sucursalServices;

    @GetMapping
    public List<Sucursal> getSucursales(){
        return sucursalServices.getSucursales();
    }
    @GetMapping("/{id}")
    public Optional<Sucursal> getSucursalId(@PathVariable Long id){
        return sucursalServices.getSucursalesId(id);
    }
    @PostMapping
    public Sucursal postSucursal(@RequestBody Sucursal sucursal){
       sucursalServices.postSucursal(sucursal);
       return sucursal;
    }

    @PutMapping("/{id}")
    public Sucursal putSucursal(@PathVariable Long id, @RequestBody Sucursal sucursal){
        return sucursalServices.putSucursal(sucursal,id);

    }
    @DeleteMapping("/{id}")
    public String deleteSucursal(@PathVariable Long id){
        sucursalServices.deleteSucursales(id);
        return "Sucursal: " +id+ "eliminado";
    }

}
