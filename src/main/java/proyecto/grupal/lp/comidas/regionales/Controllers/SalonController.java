package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Salon;
import proyecto.grupal.lp.comidas.regionales.Services.ISalonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/salon")
public class SalonController {

    @Autowired
    private ISalonService salonService;

    @GetMapping
    public List<Salon> getAllSalones() {
        return salonService.getAllSalones();
    }

    @GetMapping("/{id}")
    public Optional<Salon> getSalonById(@PathVariable Long id) {
        return salonService.getSalonById(id);
    }

    @PostMapping
    public Salon postSalon(@RequestBody Salon request) {
        salonService.postSalon(request);
        return request;
    }

    @PutMapping("/{id}")
    public Salon putSalon(@PathVariable Long id, @RequestBody Salon request) {
        return salonService.putSalon(request, id);
    }

    @PatchMapping("/{id}")
    public Salon patchSalon(@PathVariable Long id, @RequestBody Salon request) {
        return salonService.patchSalon(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteSalon(@PathVariable Long id) {
        salonService.deleteSalon(id);
        return "Salon con id=" + id + " eliminado correctamente";
    }

}
