package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Categoria;
import proyecto.grupal.lp.comidas.regionales.Entities.Establecimiento;
import proyecto.grupal.lp.comidas.regionales.Repositories.EstablecimientoRepository;
import proyecto.grupal.lp.comidas.regionales.Services.ICategoriaService;
import proyecto.grupal.lp.comidas.regionales.Services.IEstableciminetoServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> getCategoriaById(@PathVariable Long id) {
        return categoriaService.getCategoriaById(id);
    }

    @PostMapping
    public Categoria postCategoria(@RequestBody Categoria request) {
        categoriaService.postCategoria(request);
        return request;
    }

    @PutMapping("/{id}")
    public Categoria putCategoria(@PathVariable Long id, @RequestBody Categoria request) {
        return categoriaService.putCategoria(request, id);
    }

    @PatchMapping("/{id}")
    public Categoria patchCategoria(@PathVariable Long id, @RequestBody Categoria request) {
        return categoriaService.patchCategoria(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return "Categoria con id=" + id + " eliminado correctamente";
    }
}
