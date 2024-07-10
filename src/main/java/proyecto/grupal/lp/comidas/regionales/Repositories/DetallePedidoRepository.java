package proyecto.grupal.lp.comidas.regionales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proyecto.grupal.lp.comidas.regionales.Dto.DetallePedidoProductoDto;
import proyecto.grupal.lp.comidas.regionales.Entities.DetallePedido;
import proyecto.grupal.lp.comidas.regionales.Entities.Pedido;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
    @Query("SELECT COUNT(e.pedido) FROM DetallePedido e WHERE e.pedido.id = :id")
    long countIdByDetallePedido(@Param("id") Long id);

    @Query(value = "SELECT * FROM detalle_pedido WHERE detalle_pedido.estado = :estado", nativeQuery = true)
    List<DetallePedido> detallePedidoActivo(@Param("estado") Boolean estado);

    @Query(value = "SELECT * FROM detalle_pedido WHERE detalle_pedido.estado = true AND detalle_pedido.pedido_id = :pedidoId", nativeQuery = true)
    List<DetallePedido> detallePedidoPorPedido(@Param("pedidoId") Long pedidoId);
}
