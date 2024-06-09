package proyecto.grupal.lp.comidas.regionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.grupal.lp.comidas.regionales.Entities.Carta;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Long> {
}
