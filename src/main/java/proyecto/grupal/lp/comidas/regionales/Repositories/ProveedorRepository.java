package proyecto.grupal.lp.comidas.regionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.grupal.lp.comidas.regionales.Entities.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}