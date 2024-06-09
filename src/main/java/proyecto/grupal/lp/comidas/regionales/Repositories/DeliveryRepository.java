package proyecto.grupal.lp.comidas.regionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.grupal.lp.comidas.regionales.Entities.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
