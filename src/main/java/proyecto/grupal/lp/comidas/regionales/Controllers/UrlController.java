package proyecto.grupal.lp.comidas.regionales.Controllers;
import proyecto.grupal.lp.comidas.regionales.Entities.Url;
import proyecto.grupal.lp.comidas.regionales.Services.IUrlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/url")
public class UrlController {

    @Autowired
    private IUrlService urlService;

    @GetMapping
    public List<Url> getAllUrl() {
        return urlService.getAllUrl();
    }

    @GetMapping("/{id}")
    public Optional<Url> getUrlById(@PathVariable Long id) {
        return urlService.getUrlById(id);
    }

    @PostMapping
    public Url postUrl(@RequestBody Url url) {
        urlService.postUrl(url);
        return url;
    }

    @PutMapping("/{id}")
    public Url putUrl(@PathVariable Long id, @RequestBody Url url) {
        return urlService.putUrl(url, id);
    }

    @DeleteMapping("/{id}")
    public String deleteUrl(@PathVariable Long id) {
        urlService.deleteUrl(id);
        return "URL con id=" + id + " eliminado correctamente";
    }
}
