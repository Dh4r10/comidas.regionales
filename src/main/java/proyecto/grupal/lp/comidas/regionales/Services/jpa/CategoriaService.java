package proyecto.grupal.lp.comidas.regionales.Services.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.grupal.lp.comidas.regionales.Entities.Categoria;
import proyecto.grupal.lp.comidas.regionales.Repositories.CategoriaRepository;
import proyecto.grupal.lp.comidas.regionales.Services.ICategoriaService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> getCategoriaById(Long id) {
        return categoriaRepository.findById(id);
    }

    public void postCategoria(Categoria request) {

        if (request.getEstado() == null) {
            request.setEstado(true);
        }

        categoriaRepository.save(request);
    }

    public Categoria putCategoria(Categoria request, Long id) {
        Categoria categoria = categoriaRepository.findById(id).get();

        categoria.setSeccion(request.getSeccion());
        categoria.setNombre(request.getNombre());

        if (request.getEstado() == null) {
            categoria.setEstado(categoria.getEstado());
        } else {
            categoria.setEstado(request.getEstado());
        }

        return categoriaRepository.save(categoria);
    }

    public Categoria patchCategoria(Categoria request, Long id) {
        Categoria categoria = categoriaRepository.findById(id).get();

        if (request.getSeccion() == null) {
            categoria.setSeccion(categoria.getSeccion());
        } else {
            categoria.setSeccion(request.getSeccion());
        }

        if (request.getNombre() == null) {
            categoria.setNombre(categoria.getNombre());
        } else {
            categoria.setNombre(request.getNombre());
        }

        if (request.getEstado() == null) {
            categoria.setEstado(categoria.getEstado());
        } else {
            categoria.setEstado(request.getEstado());
        }

        return categoriaRepository.save(categoria);
    }

    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }


}
