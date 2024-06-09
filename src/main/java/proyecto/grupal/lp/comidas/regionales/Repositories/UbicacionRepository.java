package proyecto.grupal.lp.comidas.regionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.grupal.lp.comidas.regionales.Entities.Ubicacion;

public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {
}