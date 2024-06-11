package proyecto.grupal.lp.comidas.regionales.Repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.grupal.lp.comidas.regionales.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long > {
	Optional<Usuario> findByUsername(String username);
}
