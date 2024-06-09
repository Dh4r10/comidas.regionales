package proyecto.grupal.lp.comidas.regionales.Services;

import proyecto.grupal.lp.comidas.regionales.Entities.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {

    List<Categoria> getAllCategorias();
    Optional<Categoria> getCategoriaById(Long id);
    void postCategoria(Categoria request);
    Categoria putCategoria(Categoria request, Long id);
    Categoria patchCategoria(Categoria request, Long id);
    void deleteCategoria(Long id);

}
