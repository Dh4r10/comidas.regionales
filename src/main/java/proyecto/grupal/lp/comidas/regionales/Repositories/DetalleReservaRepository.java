package proyecto.grupal.lp.comidas.regionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.grupal.lp.comidas.regionales.Entities.DetalleReserva;

@Repository
public interface DetalleReservaRepository extends JpaRepository<DetalleReserva, Long> {
}
