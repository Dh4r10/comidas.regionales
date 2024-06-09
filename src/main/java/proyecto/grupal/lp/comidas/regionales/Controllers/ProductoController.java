package proyecto.grupal.lp.comidas.regionales.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.grupal.lp.comidas.regionales.Entities.Producto;
import proyecto.grupal.lp.comidas.regionales.Services.IProductoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

     @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public Optional<Producto> getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }

    @PostMapping
    public Producto postProducto(@RequestBody Producto request) {
        productoService.postProducto(request);
        return request;
    }

    @PutMapping("/{id}")
    public Producto putProducto(@PathVariable Long id, @RequestBody Producto request) {
        return productoService.putProducto(request, id);
    }

    @PatchMapping("/{id}")
    public Producto patchProducto(@PathVariable Long id, @RequestBody Producto request) {
        return productoService.patchProducto(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return "Producto con id=" + id + " eliminado correctamente";
    }

}
