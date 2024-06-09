package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    List<Producto> getAllProductos();
    Optional<Producto> getProductoById(Long id);
    void postProducto(Producto request);
    Producto putProducto(Producto request, Long id);
    Producto patchProducto(Producto request, Long id);
    void deleteProducto(Long id);

}
