package proyecto.grupal.lp.comidas.regionales.Services;

import java.util.List;
import java.util.Optional;
import proyecto.grupal.lp.comidas.regionales.Entities.Usuario;

public interface IUsuarioService {
    List<Usuario> getAllUsuario();
    Optional<Usuario> getUsuarioById(Long id);
    Usuario postUsuario(Usuario request, Long tipoUsuarioID);
    Usuario putUsuario(Usuario request, Long id);
    void deleteUsuario(Long id);

}
