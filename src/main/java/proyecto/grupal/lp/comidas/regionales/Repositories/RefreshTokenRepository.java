package proyecto.grupal.lp.comidas.regionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import proyecto.grupal.lp.comidas.regionales.Entities.RefreshToken;
import proyecto.grupal.lp.comidas.regionales.Entities.Usuario;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {



    Optional<RefreshToken> findByToken(String token);

    @Transactional
    void deleteByUsuario(Usuario usuario);
}
