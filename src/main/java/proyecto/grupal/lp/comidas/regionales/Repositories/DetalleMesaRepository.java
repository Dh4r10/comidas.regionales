package proyecto.grupal.lp.comidas.regionales.Repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proyecto.grupal.lp.comidas.regionales.Dto.PedidoDto;
import proyecto.grupal.lp.comidas.regionales.Entities.DetalleMesa;
import proyecto.grupal.lp.comidas.regionales.Entities.DetallePedido;
import proyecto.grupal.lp.comidas.regionales.Entities.Pedido;

import java.util.List;

@Repository
public interface DetalleMesaRepository extends JpaRepository<DetalleMesa, Long> {
    @Query("SELECT COUNT(e.pedido) FROM DetalleMesa e WHERE e.pedido.id = :id")
    long countIdByDetalleMesa(@Param("id") Long id);

    @Query(value = "SELECT * FROM detalle_mesa WHERE detalle_mesa.estado = true AND detalle_mesa.pedido_id = :pedidoId", nativeQuery = true)
    List<DetalleMesa> detalleMesaPorPedido(@Param("pedidoId") Long pedidoId);

    List<DetalleMesa> findAllByPedido(Pedido pedido);
}
