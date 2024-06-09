package proyecto.grupal.lp.comidas.regionales.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.grupal.lp.comidas.regionales.Entities.Insumo;

public interface InsumoRepository extends JpaRepository<Insumo, Long> {
}