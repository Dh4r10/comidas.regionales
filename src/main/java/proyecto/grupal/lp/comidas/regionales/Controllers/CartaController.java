package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Carta;
import proyecto.grupal.lp.comidas.regionales.Services.ICartaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carta")
public class CartaController {

    @Autowired
    private ICartaService cartaService;

    @GetMapping
    public List<Carta> getAllCartas() {
        return cartaService.getAllCartas();
    }

    @GetMapping("/{id}")
    public Optional<Carta> getCartaById(@PathVariable Long id) {
        return cartaService.getCartaById(id);
    }

    @PostMapping
    public Carta postCarta(@RequestBody Carta request) {
        cartaService.postCarta(request);
        return request;
    }

    @PutMapping("/{id}")
    public Carta putCarta(@PathVariable Long id, @RequestBody Carta request) {
        return cartaService.putCarta(request, id);
    }

    @PatchMapping("/{id}")
    public Carta patchCarta(@PathVariable Long id, @RequestBody Carta request) {
        return cartaService.patchCarta(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteCarta(@PathVariable Long id) {
        cartaService.deleteCarta(id);
        return "Carta con id=" + id + " eliminado correctamente";
    }

}
