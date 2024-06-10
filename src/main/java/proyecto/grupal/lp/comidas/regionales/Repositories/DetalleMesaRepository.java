package proyecto.grupal.lp.comidas.regionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proyecto.grupal.lp.comidas.regionales.Entities.DetalleMesa;

@Repository
public interface DetalleMesaRepository extends JpaRepository<DetalleMesa, Long> {
    @Query("SELECT COUNT(e.pedido) FROM DetalleMesa e WHERE e.pedido.id = :id")
    long countIdByDetalleMesa(@Param("id") Long id);
}
