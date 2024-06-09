package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Producto;
import proyecto.grupal.lp.comidas.regionales.Repositories.ProductoRepository;
import proyecto.grupal.lp.comidas.regionales.Services.IProductoService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(id);
    }

    public void postProducto(Producto request) {

        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        productoRepository.save(request);
    }

    public Producto putProducto(Producto request, Long id) {
        Producto producto = productoRepository.findById(id).get();

        producto.setCategoria(request.getCategoria());
        producto.setTipoProducto(request.getTipoProducto());
        producto.setNombre(request.getNombre());
        producto.setDescripcion(request.getDescripcion());
        producto.setPrecio(request.getPrecio());
        producto.setImagen(request.getImagen());

        if (request.getEstado() == null) {
            producto.setEstado(producto.getEstado());
        } else {
            producto.setEstado(request.getEstado());
        }

        return productoRepository.save(producto);
    }

    public Producto patchProducto(Producto request, Long id) {
        Producto producto = productoRepository.findById(id).get();

        if (request.getCategoria() == null) {
            producto.setCategoria(producto.getCategoria());
        } else {
            producto.setCategoria(request.getCategoria());
        }

        if (request.getTipoProducto() == null) {
            producto.setTipoProducto(producto.getTipoProducto());
        } else {
            producto.setTipoProducto(request.getTipoProducto());
        }

        if (request.getNombre() == null) {
            producto.setNombre(producto.getNombre());
        } else {
            producto.setNombre(request.getNombre());
        }

        if (request.getDescripcion() == null) {
            producto.setDescripcion(producto.getDescripcion());
        } else {
            producto.setDescripcion(request.getDescripcion());
        }

        if (request.getPrecio() == null) {
            producto.setPrecio(producto.getPrecio());
        } else {
            producto.setPrecio(request.getPrecio());
        }

        if (request.getImagen() == null) {
            producto.setImagen(producto.getImagen());
        } else {
            producto.setImagen(request.getImagen());
        }

        if (request.getEstado() == null) {
            producto.setEstado(producto.getEstado());
        } else {
            producto.setEstado(request.getEstado());
        }

        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }


}
