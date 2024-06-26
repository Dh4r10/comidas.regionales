package proyecto.grupal.lp.comidas.regionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proyecto.grupal.lp.comidas.regionales.Entities.DetallePedido;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
    @Query("SELECT COUNT(e.pedido) FROM DetallePedido e WHERE e.pedido.id = :id")
    long countIdByDetallePedido(@Param("id") Long id);
}
