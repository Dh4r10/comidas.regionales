package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Delivery;
import proyecto.grupal.lp.comidas.regionales.Services.IDeliveryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/delivery")
public class DeliveryController {

    @Autowired
    private IDeliveryService deliveryService;

    @GetMapping
    public List<Delivery> getAllDeliveries(){
        return deliveryService.getAllDeliveries();
    }

    @GetMapping("/{id}")
    public Optional<Delivery> getDeliveryById(@PathVariable Long id){
        return deliveryService.getDeliveryById(id);
    }

    @PostMapping
    public Delivery postDelivery(@RequestBody Delivery request){
        deliveryService.postDelivery(request);
        return request;
    }

    @PutMapping("/{id}")
    public Delivery putDelivery(@PathVariable Long id, @RequestBody Delivery request){
        return deliveryService.putDelivery(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteDelivery(@PathVariable Long id){
        deliveryService.deleteDelivery(id);
        return "Delivery con id=" + id + " eliminado correctamente";
    }

}
